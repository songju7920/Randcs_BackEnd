package org.example.common.error;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RandcsException extends RuntimeException {
    public final GlobalErrorCode errorCode;
}