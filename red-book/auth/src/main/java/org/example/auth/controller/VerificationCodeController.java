package org.example.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.auth.domain.req.SendVerificationCodeReq;
import org.example.auth.service.VerificationCodeService;
import org.example.framework.biz.operationlog.aspect.ApiOperationLog;
import org.example.framework.common.response.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nyxcirea
 * @date 2025/12/8 19:45
 * @description: TODO
 */
@Tag(name = "验证码服务")
@RestController
@RequiredArgsConstructor
public class VerificationCodeController {
	private final VerificationCodeService verificationCodeService;
	
	@PostMapping("/verification/code/send")
	@Operation(summary = "发送短信验证码")
	@ApiOperationLog(description = "发送短信验证码")
	public R<?> send(@Validated @RequestBody SendVerificationCodeReq sendVerificationCodeReqVO) {
		//return R.ok();
		return verificationCodeService.send(sendVerificationCodeReqVO);
	}
}
