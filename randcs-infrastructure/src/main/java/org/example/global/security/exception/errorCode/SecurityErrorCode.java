package org.example.global.security.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.error.GlobalErrorCode;

@RequiredArgsConstructor
public enum SecurityErrorCode implements GlobalErrorCode {
    TOKEN_NOT_VALID(401, "토큰이 유효하지 않습니다"),
    TOKEN_EXPIRED(401, "토큰이 만료되었습니다"),
    TOKEN_IS_NOT_ACCESS(401, "Refresh 토큰으로 유저를 인증하려 시도했습니다");

    private final int errorCode;
    private final String errorMessage;

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
