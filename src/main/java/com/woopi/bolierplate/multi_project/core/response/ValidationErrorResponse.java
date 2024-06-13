package com.woopi.bolierplate.multi_project.core.response;

import lombok.Getter;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.woopi.bolierplate.multi_project.core.enums.ErrorCodeEnum;

import java.util.List;
import java.util.Objects;

// TODO : 이거 필요 없을거 같은데.....
@Getter
public class ValidationErrorResponse {

    private final String code;
    private List<FieldErrorMessage> fieldErrorMessages;
    private final int status;
    private final String desc;

    public ValidationErrorResponse() {
        this.code = ErrorCodeEnum.VALIDATION_CHECK.getValue();
        this.status = ErrorCodeEnum.VALIDATION_CHECK.getStatus();
        this.desc = ErrorCodeEnum.VALIDATION_CHECK.getDesc();
    }

    public ValidationErrorResponse(BindingResult bindingResult) {
        this();

        if (Objects.isNull(bindingResult)) {
            return;
        }

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (CollectionUtils.isEmpty(fieldErrors)) {
            return;
        }

        this.fieldErrorMessages = fieldErrors.stream()
                .map(FieldErrorMessage::new)
                .toList();
    }

    @Getter
    static class FieldErrorMessage {

        private String field;
        private String errorMessage;

        public FieldErrorMessage(FieldError fieldError) {
            if (Objects.isNull(fieldError)) {
                return;
            }
            this.field = fieldError.getField();
            this.errorMessage = fieldError.getDefaultMessage();
        }
    }
}
