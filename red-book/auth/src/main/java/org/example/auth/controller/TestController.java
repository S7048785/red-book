package org.example.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.framework.biz.operationlog.aspect.ApiOperationLog;
import org.example.framework.common.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Tag(name = "测试")
@RestController
public class TestController {
	
	@Operation(summary = "测试接口")
	@GetMapping("/test")
	@ApiOperationLog(description = "测试接口")
	public R<Object> test() {
		return R.ok(User.builder().nickName("小红书").createTime(LocalDateTime.now()).build());
	}
}
