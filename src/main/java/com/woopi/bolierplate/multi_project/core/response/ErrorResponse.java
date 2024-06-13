package com.woopi.bolierplate.multi_project.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.woopi.bolierplate.multi_project.core.enums.ErrorCodeEnum;
import com.woopi.bolierplate.multi_project.core.exception.BusinessException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private final String status;
    private final String errorMessage;

    public ErrorResponse(BusinessException e) {
        this.status = e.getStatus();
        this.errorMessage = e.getMessage();
    }

    public ErrorResponse(ErrorCodeEnum errorType, String errorMessage) {
        this.status = errorType.getValue();
        this.errorMessage = errorMessage;
    }


    public ErrorResponse(String errorType, String errorMessage) {
        this.status = errorType;
        this.errorMessage = errorMessage;
    }
}
