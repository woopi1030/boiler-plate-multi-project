package com.woopi.bolierplate.multi_project.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    private static final String OK_STATUS = "OK";

    private String statusCode;
    private T data;

    public BaseResponse(String statusCode) {
        this.statusCode = statusCode;
    }

    private BaseResponse(String statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public static <T> BaseResponse<T> successWithNoData() {
        return new BaseResponse<>(OK_STATUS);
    }

    public static <T> BaseResponse<T> customCodeWithNoData(String statusCode) {
        return new BaseResponse<>(statusCode);
    }

    public static <T> BaseResponse<T> successWithData(T data) {
        return new BaseResponse<>(OK_STATUS, data);
    }

    public static <T> BaseResponse<T> customCodeWithData(String statusCode, T data) {
        return new BaseResponse<>(statusCode, data);
    }
}