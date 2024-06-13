package com.woopi.bolierplate.multi_project.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.woopi.bolierplate.multi_project.core.enums.ErrorCodeEnum;
import com.woopi.bolierplate.multi_project.core.response.ErrorResponse;
import com.woopi.bolierplate.multi_project.core.response.ValidationErrorResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidFormatException(HttpMessageNotReadableException e) {
        log.error(e.getMessage(), e);
        final ErrorResponse response = new ErrorResponse(ErrorCodeEnum.VALIDATION_CHECK, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCodeEnum.VALIDATION_CHECK.getStatus()));
    }

    /**
     * RequestBody 값 검증
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, BindingResult bindingResult) {
        log.error(e.getMessage(), e);
        final ValidationErrorResponse response = new ValidationErrorResponse(bindingResult);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    /**
     * QueryString 값 검증
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ValidationErrorResponse> handleBindException(BindException e, BindingResult bindingResult) {
        log.error(e.getMessage(), e);
        final ValidationErrorResponse response = new ValidationErrorResponse(bindingResult);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    /**
     * 비즈니스 예외 발생
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        log.error(e.getStatus(), e);
        log.error(e.getMessage(), e);
        final ErrorResponse response = new ErrorResponse(e.getStatus(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorStatus()));
    }

    /**
     * enum type 일치하지 않아 binding 못할 경우 발생
     * 주로 @RequestParam enum으로 binding 못했을 경우 발생
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error(e.getMessage(), e);
        final ErrorResponse response = new ErrorResponse(ErrorCodeEnum.VALIDATION_CHECK, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCodeEnum.VALIDATION_CHECK.getStatus()));
    }

    /**
     * 클라이언트에서 잘못된 값 입력 시 발생
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(e.getMessage(), e);
        final ErrorResponse response = new ErrorResponse(ErrorCodeEnum.VALIDATION_CHECK, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCodeEnum.VALIDATION_CHECK.getStatus()));
    }

    /**
     * 런타임 exception
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        final ErrorResponse response = new ErrorResponse(ErrorCodeEnum.INTERNAL_SERVER_ERROR, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getStatus()));
    }

    /**
     * Exception 나머지 에러 일 경우
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error(e.getMessage(), e);
        final ErrorResponse response = new ErrorResponse(ErrorCodeEnum.INTERNAL_SERVER_ERROR, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getStatus()));
    }
}

