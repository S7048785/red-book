package org.example.framework.common.response;

import lombok.Data;
import org.example.framework.common.exception.BaseExceptionInterface;
import org.example.framework.common.exception.BizException;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {
	
	// 是否成功，默认为 true
	private boolean success = true;
	// 响应消息
	private String msg;
	// 异常码
	private String code;
	// 响应数据
	private T data;
	
	// =================================== 成功响应 ===================================
	public static <T> R<T> ok() {
		return new R<>();
	}
	
	public static <T> R<T> ok(T data) {
		R<T> response = new R<>();
		response.setData(data);
		return response;
	}
	
	// =================================== 失败响应 ===================================
	public static <T> R<T> fail() {
		R<T> response = new R<>();
		response.setSuccess(false);
		return response;
	}
	
	public static <T> R<T> fail(String errorMessage) {
		R<T> response = new R<>();
		response.setSuccess(false);
		response.setMsg(errorMessage);
		return response;
	}
	
	public static <T> R<T> fail(String errorCode, String errorMessage) {
		R<T> response = new R<>();
		response.setSuccess(false);
		response.setCode(errorCode);
		response.setMsg(errorMessage);
		return response;
	}
	
	public static <T> R<T> fail(BizException bizException) {
		R<T> response = new R<>();
		response.setSuccess(false);
		response.setCode(bizException.getErrorCode());
		response.setMsg(bizException.getErrorMessage());
		return response;
	}
	
	public static <T> R<T> fail(BaseExceptionInterface baseExceptionInterface) {
		R<T> response = new R<>();
		response.setSuccess(false);
		response.setCode(baseExceptionInterface.getErrorCode());
		response.setMsg(baseExceptionInterface.getErrorMessage());
		return response;
	}
	
}
