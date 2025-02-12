package org.example.common.error.exception;

import org.example.common.error.RandcsException;
import org.example.common.error.exception.errorCode.UtilErrorCode;

public class CodeNotMatchesException extends RandcsException {
    public static final CodeNotMatchesException EXCEPTION = new CodeNotMatchesException();

    public CodeNotMatchesException() { super(UtilErrorCode.CODE_NOT_MATCHES); }
}
