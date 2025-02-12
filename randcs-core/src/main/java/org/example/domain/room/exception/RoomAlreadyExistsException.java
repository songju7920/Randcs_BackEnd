package org.example.domain.room.exception;

import org.example.common.error.RandcsException;
import org.example.domain.room.exception.errorCode.RoomErrorCode;

public class RoomAlreadyExistsException extends RandcsException {
    public static final RoomAlreadyExistsException EXCEPTION = new RoomAlreadyExistsException();

    public RoomAlreadyExistsException() { super(RoomErrorCode.ROOM_ALREADY_EXISTS); }
}
