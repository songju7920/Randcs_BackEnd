package org.example.global.exception.generalExceptions.errorCode

import org.example.common.error.GlobalErrorCode

enum class GeneralErrorCode (
    private val code: Int,
    private val message: String
) : GlobalErrorCode {

    BAD_REQUEST_EXCEPTION(400, "요청 형식이 잘못됬습니다"),
    INTERNAL_SERVER_ERROR(500, "서버애러가 발생했습니다");

    override fun getErrorCode(): Int = code
    override fun getErrorMessage(): String = message
}
