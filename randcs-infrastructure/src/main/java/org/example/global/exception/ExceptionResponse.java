package org.example.global.exception;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

import java.time.LocalDateTime;

public record ExceptionResponse(
        int statusCode,
        String message,
        String description,
        LocalDateTime timeStamp)
{
    public static ExceptionResponse of (GlobalErrorCode errorCode, String description) {
        return new ExceptionResponse(errorCode.getErrorCode(), errorCode.getErrorMessage(), description, LocalDateTime.now());
    }
}
