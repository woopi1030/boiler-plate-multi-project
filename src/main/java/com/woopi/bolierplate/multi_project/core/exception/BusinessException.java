package com.woopi.bolierplate.multi_project.core.exception;


import com.woopi.bolierplate.multi_project.core.enums.ErrorCodeEnum;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final String status;

    private final String message;

    private final Integer errorStatus;

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        this.status = errorCodeEnum.getValue();
        this.message = errorCodeEnum.getDesc();
        this.errorStatus = errorCodeEnum.getStatus();
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum, String message) {
        this.status = errorCodeEnum.getValue();
        this.message = message;
        this.errorStatus = errorCodeEnum.getStatus();
    }

    public BusinessException(String status, String message, Integer errorStatus) {
        this.status = status;
        this.message = message;
        this.errorStatus = errorStatus;
    }
}