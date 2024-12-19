package org.example.common.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RandcsException extends RuntimeException {
    public final GlobalErrorCode errorCode;
}