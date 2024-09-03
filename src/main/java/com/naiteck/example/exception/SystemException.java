package com.naiteck.example.exception;

/**
 * 自定义普通异常
 * @author jiangwen
 */
public class SystemException extends RuntimeException {

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemException(String message) {
		super(message);
	}

}
