package org.example.global.security.exception;

import org.example.common.error.RandcsException;
import org.example.global.security.exception.errorCode.SecurityErrorCode;

public class ExpiredTokenException extends RandcsException {
    public static final ExpiredTokenException EXCEPTION = new ExpiredTokenException();
    protected ExpiredTokenException() { super(SecurityErrorCode.TOKEN_EXPIRED); }
}
