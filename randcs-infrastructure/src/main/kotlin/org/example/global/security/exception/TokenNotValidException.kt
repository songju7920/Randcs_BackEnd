package org.example.global.security.exception

import org.example.common.error.RandcsException
import org.example.global.security.exception.errorCode.SecurityErrorCode

object TokenNotValidException : RandcsException(
        SecurityErrorCode.TOKEN_NOT_VALID
)
