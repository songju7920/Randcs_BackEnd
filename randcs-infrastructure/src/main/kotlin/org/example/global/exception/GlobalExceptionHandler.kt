package org.example.global.exception

import org.example.common.error.RandcsException
import org.example.global.exception.ExceptionResponse.Companion.of
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(RandcsException::class)
    protected fun coreExceptionHandler(e: RandcsException): ResponseEntity<ExceptionResponse> {
        val errorCode = e.errorCode
        val response = of(errorCode, errorCode.errorMessage)

        return ResponseEntity(response, HttpStatusCode.valueOf(errorCode.errorCode))
    }
}
