package org.example.auth.domain.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author YYJY
 * @date 2025/12/8
 * @description: TODO
 */
@Data
public class SendVerificationCodeReq {
	@Pattern(regexp = "^(13[0-9]|14[0,1,4-9]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$",
			flags = Pattern.Flag.CASE_INSENSITIVE, message = "手机号格式错误")
	@NotBlank
	private String phone;
}
