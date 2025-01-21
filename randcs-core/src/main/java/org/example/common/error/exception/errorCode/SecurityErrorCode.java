package org.example.common.error.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.error.GlobalErrorCode;

@RequiredArgsConstructor
public enum SecurityErrorCode implements GlobalErrorCode {
    PASSWORD_MISMATCHES(403, "비밀번호가 불일치합니다");

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
