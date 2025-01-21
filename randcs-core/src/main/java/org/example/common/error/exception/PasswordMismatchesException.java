package org.example.common.error.exception;

import org.example.common.error.RandcsException;
import org.example.common.error.exception.errorCode.SecurityErrorCode;

public class PasswordMismatchesException extends RandcsException {
    public static final PasswordMismatchesException Exception = new PasswordMismatchesException();

    protected PasswordMismatchesException() { super(SecurityErrorCode.PASSWORD_MISMATCHES); }
}
