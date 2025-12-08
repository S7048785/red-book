package org.example.auth.service;

import org.example.auth.dto.user.UserLoginReqInput;

/**
 * @author Nyxcirea
 * @date 2025/12/8
 * @description: 用户服务接口
 */
public interface UserService {
	
	String loginAndRegister(UserLoginReqInput userLoginReqInput);
}
