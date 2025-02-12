package org.example.common.error.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.error.GlobalErrorCode;

@RequiredArgsConstructor
public enum UtilErrorCode implements GlobalErrorCode {
    CODE_NOT_MATCHES(401, "코드가 일치하지 않습니다");

    private final int errorCode;
    private final String message;

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
}
