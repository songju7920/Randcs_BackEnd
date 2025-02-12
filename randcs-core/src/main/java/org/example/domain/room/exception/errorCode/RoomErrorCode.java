package org.example.domain.room.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.error.GlobalErrorCode;

@RequiredArgsConstructor
public enum RoomErrorCode implements GlobalErrorCode {
    ROOM_ALREADY_EXISTS(409, "이미 해당 계정으로 생성된 방이 존재합니다");

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
