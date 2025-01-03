package org.example.global.exception.generalExceptions;

import org.example.common.error.RandcsException;
import org.example.global.exception.generalExceptions.errorCode.GeneralErrorCode;

public class InternalServerErrorException extends RandcsException {
    public static final InternalServerErrorException EXCEPTION = new InternalServerErrorException();

    public InternalServerErrorException() { super(GeneralErrorCode.INTERNAL_SERVER_ERROR); }
}
