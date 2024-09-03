package com.naiteck.example.core;

import com.naiteck.example.config.ResultCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResult<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    private boolean isSuccess;

    private String version;

    public ApiResult() {
        this.setCode(ResultCode.SUCCESS.getCode());
        this.setMessage(ResultCode.SUCCESS.getMessage());
        this.setSuccess(true);
        this.setVersion(ResultCode.VERSION.getMessage());
    }


    public ApiResult(int code, String message, boolean success, T data, String version) {
        this.setCode(code);
        this.setMessage(message);
        this.setSuccess(success);
        this.setData(data);
        this.setVersion(version);
    }

    public static <T> ApiResult<T> newInstance(ResultCode resultCode, boolean success, T value, String version) {
        return new ApiResult(resultCode.getCode(), resultCode.getMessage(), success, value, version);
    }

    public static <T> ApiResult<T> ok(T value, String message) {
        return new ApiResult(ResultCode.SUCCESS.getCode(), message, true, null, ResultCode.VERSION.getMessage());
    }

    public static <T> ApiResult<T> ok() {
        return new ApiResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), true, null, ResultCode.VERSION.getMessage());
    }

    public static <T> ApiResult<T> ok(T value) {
        return new ApiResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), true, value, ResultCode.VERSION.getMessage());
    }

    public static <T> ApiResult<T> error(ResultCode errorCode) {
        return new ApiResult(errorCode.getCode(), errorCode.getMessage(), false, null, ResultCode.VERSION.getMessage());
    }

    public static <T> ApiResult<T> error(int code, String message) {
        return new ApiResult(code, message, false, null, ResultCode.VERSION.getMessage());
    }

    public static <T> ApiResult<T> error(int code, String message, Object result) {
        return new ApiResult(code, message, false, result, ResultCode.VERSION.getMessage());
    }

    public static <T> ApiResult<T> error(int code, String message, Object result, String version) {
        return new ApiResult(code, message, false, result, version);
    }

    public ApiResult<T> setErrorCode(ResultCode errorCode) {
        if (errorCode == null) {
            return null;
        } else {
            this.code = errorCode.getCode();
            this.message = errorCode.getMessage();
            this.isSuccess = false;
            this.version = ResultCode.VERSION.getMessage();
            return this;
        }
    }

    public ApiResult<T> setErrorCode(ResultCode errorCode, Object... args) {
        if (errorCode == null) {
            return null;
        } else {
            this.code = errorCode.getCode();
            this.setFormatMessage(errorCode.getMessage(), args);
            this.isSuccess = false;
            this.version = ResultCode.VERSION.getMessage();
            return this;
        }
    }


    public void setFormatMessage(String message, Object... args) {
        if (args != null && args.length != 0) {
            this.setMessage(String.format(message, args));
        } else {
            this.setMessage(message);
        }

    }
}
