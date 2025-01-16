package org.example.global.exception.generalExceptions.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.error.GlobalErrorCode;

@RequiredArgsConstructor
public enum GeneralErrorCode implements GlobalErrorCode {
    BAD_REQUEST_EXCEPTION(400, "요청 형식이 잘못됬습니다"),
    INTERNAL_SERVER_ERROR(500, "서버애러가 발생했습니다");

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
