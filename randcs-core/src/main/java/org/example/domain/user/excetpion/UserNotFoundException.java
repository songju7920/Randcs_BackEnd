package org.example.domain.user.excetpion;

import org.example.common.error.RandcsException;
import org.example.domain.user.excetpion.errorCode.UserErrorCode;

public class UserNotFoundException extends RandcsException {
    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() { super(UserErrorCode.USER_NOT_FOUND); }
}
