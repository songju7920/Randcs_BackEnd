package org.example.common.error.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.error.GlobalErrorCode;

@RequiredArgsConstructor
public enum CommonErrorCode implements GlobalErrorCode {
    BAD_REQUEST(400, "잘못된 요청을 수신했습니다"),
    INTERNAL_SERVER_ERROR(500, "서버 오류입니다. 반복될시 백엔드에게 문의해주세요");

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
