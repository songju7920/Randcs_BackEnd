package org.example.global.security.exception.errorCode;

import org.example.common.error.RandcsException;

public class TokenIsNotAccessException extends RandcsException {
    public static final TokenIsNotAccessException EXCEPTION = new TokenIsNotAccessException();
    protected TokenIsNotAccessException() { super(SecurityErrorCode.TOKEN_IS_NOT_ACCESS); }
}
