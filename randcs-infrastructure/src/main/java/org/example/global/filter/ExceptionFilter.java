package org.example.global.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.common.error.GlobalErrorCode;
import org.example.common.error.RandcsException;
import org.example.common.error.exception.errorCode.CommonErrorCode;
import org.example.global.exception.ExceptionResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (RandcsException e) {
            convertErrorCodeToJson(e.errorCode, response);
        } catch (Exception e) {
            log.error(e.getMessage());
            convertErrorCodeToJson(CommonErrorCode.INTERNAL_SERVER_ERROR, response);
        }
    }

    private void convertErrorCodeToJson(GlobalErrorCode errorCode, HttpServletResponse response) throws IOException {
        response.setStatus(errorCode.getErrorCode());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(ExceptionResponse.of(errorCode)));
    }
}
