package com.naiteck.example.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode {

    SUCCESS(200,"成功"),
    ERROR(500,"失败"),

    VERSION(999,"1.0");

    final int code;
    final String message;

    public static ResultCode format(String name) {
        for (ResultCode value : ResultCode.values()) {
            if (name.equals(value.toString())) {
                return value;
            }
        }
        return null;

    }
}
