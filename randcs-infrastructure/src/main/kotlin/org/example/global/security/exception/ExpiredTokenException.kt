package org.example.global.security.exception

import org.example.common.error.RandcsException
import org.example.global.security.exception.errorCode.SecurityErrorCode

object ExpiredTokenException : RandcsException(
        SecurityErrorCode.TOKEN_EXPIRED
)