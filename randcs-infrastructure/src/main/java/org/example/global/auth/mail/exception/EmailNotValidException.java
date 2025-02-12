package org.example.global.auth.mail.exception;

import org.example.common.error.RandcsException;
import org.example.global.auth.mail.exception.errorCode.EmailErrorCode;

public class EmailNotValidException extends RandcsException {
    public static final EmailNotValidException EXCEPTION = new EmailNotValidException();

    public EmailNotValidException() { super(EmailErrorCode.EMAIL_ERROR_CODE); }
}
