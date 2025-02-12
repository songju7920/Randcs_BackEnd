package org.example.global.exception;

import org.example.common.error.GlobalErrorCode;
import org.example.common.error.exception.errorCode.CommonErrorCode;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.example.common.error.RandcsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RandcsException.class)
    protected ResponseEntity<ExceptionResponse> coreExceptionHandler(RandcsException e) {
        GlobalErrorCode errorCode = e.errorCode;
        ExceptionResponse response = ExceptionResponse.of(errorCode, errorCode.getErrorMessage());

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(errorCode.getErrorCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionResponse> validationExceptionHandler(MethodArgumentNotValidException e) {
        String description = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + " : " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(" / "));
        ExceptionResponse response = ExceptionResponse.of(CommonErrorCode.BAD_REQUEST, description);

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(400));
    }
}
