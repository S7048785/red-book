package org.example.auth.service;

import org.example.auth.domain.req.SendVerificationCodeReq;
import org.example.framework.common.response.R;

/**
 * @author Nyxcirea
 * @date 2025/12/8
 * @description: TODO
 */
public interface VerificationCodeService {
	/**
	 * 发送短信验证码
	 * @param sendVerificationCodeReqVO 手机号
	 * @return 响应结果
	 */
	R<?> send(SendVerificationCodeReq sendVerificationCodeReqVO);
}
