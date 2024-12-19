package org.example.global.exception;

import org.example.common.exception.GlobalErrorCode;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.example.common.exception.RandcsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RandcsException.class)
    protected ResponseEntity<ExceptionResponse> coreExceptionHandler(RandcsException e) {
        GlobalErrorCode errorCode = e.errorCode;
        ExceptionResponse response = ExceptionResponse.of(errorCode, errorCode.getErrorMessage());

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(errorCode.getErrorCode()));
    }
}
