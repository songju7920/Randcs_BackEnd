package org.example.global.security.exception;

import org.example.common.error.RandcsException;
import org.example.global.security.exception.errorCode.SecurityErrorCode;

public class TokenNotValidException extends RandcsException {
    public static final TokenNotValidException EXCEPTION = new TokenNotValidException();
    protected TokenNotValidException() { super(SecurityErrorCode.TOKEN_NOT_VALID); }
}
