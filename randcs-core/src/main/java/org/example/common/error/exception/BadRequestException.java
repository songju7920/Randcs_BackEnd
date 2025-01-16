package org.example.common.error.exception;

import org.example.common.error.RandcsException;

public class BadRequestException extends RandcsException {
    public static final BadRequestException EXCEPTION = new BadRequestException();
    protected BadRequestException() { super(CommonErrorCode.BAD_REQUEST); }
}
