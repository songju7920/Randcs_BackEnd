package org.example.domain.room.exception;

import org.example.common.error.RandcsException;
import org.example.domain.room.exception.errorCode.RoomErrorCode;

public class RoomNotExistsException extends RandcsException {
    public static final RoomNotExistsException EXCEPTION = new RoomNotExistsException();

    public RoomNotExistsException() { super(RoomErrorCode.ROOM_NOT_EXISTS); }
}
