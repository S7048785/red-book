package org.example.auth.service.impl;

import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.auth.constant.RedisKeyConstant;
import org.example.auth.domain.req.SendVerificationCodeReq;
import org.example.auth.enums.ResponseCodeEnum;
import org.example.auth.service.VerificationCodeService;
import org.example.auth.sms.AliyunSmsHelper;
import org.example.framework.common.exception.BizException;
import org.example.framework.common.response.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Nyxcirea
 * @date 2025/12/8
 * @description: TODO
 */
@Slf4j
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Resource(name = "taskExecutor")
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@Resource
	private AliyunSmsHelper aliyunSmsHelper;
	
	@Override
	public R<?> send(SendVerificationCodeReq sendVerificationCodeReqVO) {
		String phone = sendVerificationCodeReqVO.getPhone();
		// 校验手机号格式
		boolean isPhone = PhoneUtil.isPhone(phone);
		if (!isPhone) {
			throw new BizException(ResponseCodeEnum.PHONE_NUMBER_FORMAT_ERROR);
		}
		
		String key = RedisKeyConstant.buildVerificationCodeKey( phone);
		
		if (Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
			throw new BizException(ResponseCodeEnum.VERIFICATION_CODE_SEND_FREQUENTLY);
		}
		// 生成 6 位随机数字验证码
		String verificationCode = RandomUtil.randomNumbers(6);
		
		// 调用第三方短信发送服务
		//threadPoolTaskExecutor.submit(() -> {
		//	String signName = "速通互联验证码"; // 签名，个人测试签名无法修改
		//	String templateCode = "100001"; // 短信模板编码
		//	// 短信模板参数，code 表示要发送的验证码；min 表示验证码有时间时长，即 3 分钟
		//	String templateParam = String.format("{\"code\":\"%s\",\"min\":\"3\"}", verificationCode);
		//	aliyunSmsHelper.sendMessage(signName, templateCode, phone, templateParam);
		//});
		//log.info("==> 手机号: {}, 已发送验证码：【{}】", phone, verificationCode);
		
		// 存储验证码到 redis, 并设置过期时间为 3 分钟
		redisTemplate.opsForValue().set(key, verificationCode, 3, TimeUnit.MINUTES);
		return R.ok();
	}
}
