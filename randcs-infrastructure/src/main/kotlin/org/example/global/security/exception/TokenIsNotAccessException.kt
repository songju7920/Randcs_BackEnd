package org.example.global.security.exception

import org.example.common.error.RandcsException
import org.example.global.security.exception.errorCode.SecurityErrorCode

object TokenIsNotAccessException : RandcsException(
        SecurityErrorCode.TOKEN_IS_NOT_ACCESS
)
