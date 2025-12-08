package org.example.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.framework.common.exception.BaseExceptionInterface;

/**
 * @author Nyxcirea
 * @date 2025/12/8 19:45
 * @description: 响应状态码枚举类
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("AUTH-10000", "出错啦，后台小哥正在努力修复中..."),
    PARAM_NOT_VALID("AUTH-10001", "参数错误"),

    VERIFICATION_CODE_SEND_FREQUENTLY("AUTH-10002", "验证码发送过于频繁"),
     PHONE_NUMBER_FORMAT_ERROR("AUTH-10003", "手机号格式错误"),
    VERIFICATION_CODE_ERROR("AUTH-20001", "验证码错误"),
    PASSWORD_ERROR("AUTH-20002", "密码错误");
    // 异常码
    private final String errorCode;
    // 错误信息
    private final String errorMessage;

}

