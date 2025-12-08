package org.example.auth.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import org.example.auth.domain.po.TUser;
import org.example.auth.dto.user.UserLoginReqInput;
import org.example.auth.enums.LoginTypeEnum;
import org.example.auth.enums.ResponseCodeEnum;
import org.example.auth.repository.UserRepository;
import org.example.auth.service.UserService;
import org.example.framework.common.exception.BizException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Nyxcirea
 * @date 2025/12/8
 * @description: 用户服务实现类
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	
	private final StringRedisTemplate redisTemplate;
	private final UserRepository userRepository;
	
	/**
	 * 登录或注册用户
	 * @param userLoginReqInput 用户登录请求参数
	 * @return token
	 */
	@Override
	public String loginAndRegister(UserLoginReqInput userLoginReqInput) {
		String phone = userLoginReqInput.getPhone();
		int type = userLoginReqInput.getType();
		
		if (type == LoginTypeEnum.VERIFICATION_CODE.getValue()) {
			// 验证码登录
			return handleVerificationCodeLogin(userLoginReqInput, phone);
		} else if (type == LoginTypeEnum.PASSWORD.getValue()) {
			// 密码登录
			return handlePasswordLogin(userLoginReqInput, phone);
		}
		return null;
	}
	
	/**
	 * 处理验证码登录
	 * @param userLoginReqInput 登录请求参数
	 * @param phone 手机号
	 * @return token
	 */
	private String handleVerificationCodeLogin(UserLoginReqInput userLoginReqInput, String phone) {
		// 从Redis中获取验证码
		String verificationCode = redisTemplate.opsForValue().get(phone);
		if (verificationCode == null) {
			// 验证码不存在
			throw new BizException(ResponseCodeEnum.VERIFICATION_CODE_ERROR);
		}
		if (!verificationCode.equals(userLoginReqInput.getCode())) {
			// 验证码错误
			throw new BizException(ResponseCodeEnum.VERIFICATION_CODE_ERROR);
		}
		// 验证码正确
		// 从数据库中查询用户
		TUser user = userRepository.findByPhone(phone);
		if (user == null) {
			// 用户不存在 注册用户
			long userId = userRepository.register(userLoginReqInput);
			
		} else {
			// 用户存在 登录
			StpUtil.login(user.id());
			return StpUtil.getTokenValue();
		}
	}
	
	/**
	 * 处理密码登录
	 * @param userLoginReqInput 登录请求参数
	 * @param phone 手机号
	 * @return token
	 */
	private String handlePasswordLogin(UserLoginReqInput userLoginReqInput, String phone) {
		// 从数据库中查询用户
		TUser user = userRepository.findByPhone(phone);
		if (user == null) {
			// 用户不存在
			throw new BizException(ResponseCodeEnum.PHONE_NUMBER_FORMAT_ERROR);
		}
		// 校验密码
		if (!user.password().equals(userLoginReqInput.getPassword())) {
			// 密码错误
			throw new BizException(ResponseCodeEnum.PASSWORD_ERROR);
		}
		// 用户登录并生成token
		StpUtil.login(user.id());
		return StpUtil.getTokenValue();
	}
}