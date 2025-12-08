package org.example.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.example.auth.domain.po.Fetchers;
import org.example.auth.domain.po.TUserFetcher;
import org.example.auth.dto.user.UserLoginReqInput;
import org.example.auth.service.UserService;
import org.example.framework.biz.operationlog.aspect.ApiOperationLog;
import org.example.framework.common.response.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户接口")
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	@Operation(summary = "用户登录")
	@PostMapping("/login")
	@ApiOperationLog
	public R<String> login(UserLoginReqInput userLoginReqInput) {
	
		String loginAndRegister = userService.loginAndRegister(userLoginReqInput);
		return R.ok(loginAndRegister);
	}
	
	private final TUserFetcher UserDO = Fetchers.TUSER_FETCHER.allReferenceFields();
}

