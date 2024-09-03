package com.naiteck.example.config;

import com.naiteck.example.core.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Result exception(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(ResultCode.ERROR.getCode(), e.getMessage());
    }


    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result exception(BindException e) {
        String errorMsg = e.getBindingResult().getFieldErrors().stream()
                .map(errorInfo -> errorInfo.getField() + errorInfo.getDefaultMessage()).collect(Collectors.joining(","));
        log.warn(e.getMessage(), e);
        return Result.error(ResultCode.ERROR.getCode(), "参数校验失败:" + errorMsg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result exception(MethodArgumentNotValidException e) {
        String errorMsg = e.getBindingResult().getFieldErrors().stream()
                .map(errorInfo -> errorInfo.getField() + errorInfo.getDefaultMessage()).collect(Collectors.joining(","));
        log.warn(e.getMessage(), e);
        return Result.error(ResultCode.ERROR.getCode(), "参数校验失败:" + errorMsg);
    }

}
