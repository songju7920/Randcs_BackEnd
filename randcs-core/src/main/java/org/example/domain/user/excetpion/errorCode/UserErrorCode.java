package org.example.domain.user.excetpion.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.error.GlobalErrorCode;

@RequiredArgsConstructor
public enum UserErrorCode implements GlobalErrorCode {
    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다");

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
