package org.example.global.exception.generalExceptions;

import org.example.common.error.RandcsException;
import org.example.global.exception.generalExceptions.errorCode.GeneralErrorCode;

public class BadRequestException extends RandcsException {
    public static final BadRequestException EXCEPTION = new BadRequestException();

    public BadRequestException() { super(GeneralErrorCode.INTERNAL_SERVER_ERROR); }
}
