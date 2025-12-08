package org.example.auth.constant;


/**
 * @author Nyxcirea
 * @date 2025/12/8 17:25
 * @description: Redis Key 常量类
 */
public class RedisKeyConstant {
	
	/**
	 * 验证码 KEY 前缀
	 */
	private static final String VERIFICATION_CODE_KEY_PREFIX = "verification_code:";
	
	/**
	 * 构建验证码 KEY
	 * @param phone 手机号
	 * @return 验证码 KEY
	 */
	public static String buildVerificationCodeKey(String phone) {
		return VERIFICATION_CODE_KEY_PREFIX + phone;
	}
}
