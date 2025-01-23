package org.example.domain.user.excetpion;

import org.example.common.error.RandcsException;
import org.example.domain.user.excetpion.errorCode.UserErrorCode;

public class EmailAlreadyExistsException extends RandcsException {
    public static final EmailAlreadyExistsException EXCEPTION = new EmailAlreadyExistsException();

    public EmailAlreadyExistsException() { super(UserErrorCode.EMAIL_ALREADY_EXISTS); }
}