package com.naiteck.example.core;

import com.naiteck.example.config.ResultCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {


    private int code;
    private String message;

    private T data;

    public static <T> Result<T> ok() {
        return restResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),  null);
    }

    public static <T> Result<T> ok(T data) {
        return restResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),data);
    }

    public static <T> Result<T> ok(String message,T data) {
        return restResult(ResultCode.SUCCESS.getCode(), message,data);
    }

    public static <T> Result<T> error() {
        return restResult(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMessage(), null);
    }

    public static <T> Result<T> error(String message) {
        return restResult(ResultCode.ERROR.getCode(), message, null);
    }

    public static <T> Result<T> error(T data) {
        return restResult(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMessage(), data);
    }

    public static <T> Result<T> error(String message, T data) {
        return restResult(ResultCode.ERROR.getCode(), message, data);
    }

    public static <T> Result<T> error(int code, String message) {
        return restResult(code, message, null);
    }

    private static <T> Result<T> restResult( int code, String msg,T data) {
        Result<T> responseResult = new Result<>();
        responseResult.setCode(code);
        responseResult.setData(data);
        responseResult.setMessage(msg);
        return responseResult;
    }
}
