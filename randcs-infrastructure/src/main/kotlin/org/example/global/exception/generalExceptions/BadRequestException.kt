package org.example.global.exception.generalExceptions

import org.example.common.error.RandcsException
import org.example.global.exception.generalExceptions.errorCode.GeneralErrorCode

object BadRequestException : RandcsException (
        GeneralErrorCode.BAD_REQUEST_EXCEPTION
)
