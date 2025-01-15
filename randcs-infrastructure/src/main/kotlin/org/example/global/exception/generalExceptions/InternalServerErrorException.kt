package org.example.global.exception.generalExceptions

import org.example.common.error.RandcsException
import org.example.global.exception.generalExceptions.errorCode.GeneralErrorCode

object InternalServerErrorException : RandcsException(
        GeneralErrorCode.INTERNAL_SERVER_ERROR
)