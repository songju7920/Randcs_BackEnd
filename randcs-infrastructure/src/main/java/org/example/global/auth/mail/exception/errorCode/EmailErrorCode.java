package org.example.global.auth.mail.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.error.GlobalErrorCode;

@RequiredArgsConstructor
public enum EmailErrorCode implements GlobalErrorCode {
    EMAIL_ERROR_CODE(400, "이메일 형식이 잘못됬습니다");

    private final int code;
    private final String message;

    @Override
    public int getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
}
