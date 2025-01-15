package org.example.global.exception

import org.example.common.error.GlobalErrorCode
import java.time.LocalDateTime

data class ExceptionResponse(
    val statusCode: Int,
    val message: String,
    val description: String,
    val timeStamp: LocalDateTime
) {

    companion object {
        fun of(errorCode: GlobalErrorCode, description: String): ExceptionResponse {
            return ExceptionResponse(errorCode.errorCode, errorCode.errorMessage, description, LocalDateTime.now())
        }

        fun of(errorCode: GlobalErrorCode): ExceptionResponse {
            return ExceptionResponse(errorCode.errorCode, errorCode.errorMessage, errorCode.errorMessage, LocalDateTime.now())
        }
    }
}
