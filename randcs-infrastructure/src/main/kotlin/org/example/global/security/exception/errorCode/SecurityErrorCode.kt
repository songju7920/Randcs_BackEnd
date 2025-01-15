package org.example.global.security.exception.errorCode

import org.example.common.error.GlobalErrorCode

enum class SecurityErrorCode(
    private val errorCode: Int,
    private val errorMessage: String
) : GlobalErrorCode {

    TOKEN_NOT_VALID(401, "토큰이 유효하지 않습니다"),
    TOKEN_EXPIRED(401, "토큰이 만료되었습니다"),
    TOKEN_IS_NOT_ACCESS(401, "Refresh 토큰으로 유저를 인증하려 시도했습니다");

    override fun getErrorCode(): Int = errorCode
    override fun getErrorMessage(): String = errorMessage
}
