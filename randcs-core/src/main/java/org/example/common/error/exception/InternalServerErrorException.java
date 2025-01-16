package org.example.common.error.exception;

import org.example.common.error.RandcsException;

public class InternalServerErrorException extends RandcsException {
    public static final InternalServerErrorException Exception = new InternalServerErrorException();
    protected InternalServerErrorException() { super(CommonErrorCode.INTERNAL_SERVER_ERROR); }
}
