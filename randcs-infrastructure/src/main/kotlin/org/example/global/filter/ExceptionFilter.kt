package org.example.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.example.common.error.GlobalErrorCode
import org.example.common.error.RandcsException
import org.example.global.exception.ExceptionResponse
import org.example.global.exception.generalExceptions.errorCode.GeneralErrorCode
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: RandcsException) {
            convertErrorCodeToJson(e.errorCode, response)
        } catch (e: Exception) {
            e.printStackTrace()
            convertErrorCodeToJson(GeneralErrorCode.INTERNAL_SERVER_ERROR, response)
        }
    }

    private fun convertErrorCodeToJson(errorCode: GlobalErrorCode, response: HttpServletResponse) {
        response.status = errorCode.errorCode
        response.contentType = "application/json;charset=UTF-8"
        response.writer.write(objectMapper.writeValueAsString(ExceptionResponse.of(errorCode)))
    }
}
