package org.example.global.thirdparty.redis.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.error.GlobalErrorCode;

@RequiredArgsConstructor
public enum RedisErrorCode implements GlobalErrorCode {
    KEY_NOT_EXIST_IN_REDIS(404, "Redis에 존재하지 않는 Key 데이터입니다");

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
