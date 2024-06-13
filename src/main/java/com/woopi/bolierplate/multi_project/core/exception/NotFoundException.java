package com.woopi.bolierplate.multi_project.core.exception;

import com.woopi.bolierplate.multi_project.core.enums.ErrorCodeEnum;

public class NotFoundException extends BusinessException {
    public NotFoundException(Class<?> type, Long id) {
        super(ErrorCodeEnum.NOT_FOUND, String.format("Not Found %s. id: %d", type.getSimpleName(), id));
    }

    public NotFoundException(Class<?> type, String key, Object value) {
        super(ErrorCodeEnum.NOT_FOUND, String.format("Not Found %s. %s: %s", type.getSimpleName(), key, value));
    }

    public NotFoundException(Class<?> type, Object condition) {
        super(ErrorCodeEnum.NOT_FOUND, String.format("Not Found %s. by: %s", type.getSimpleName(), condition));
    }
}
