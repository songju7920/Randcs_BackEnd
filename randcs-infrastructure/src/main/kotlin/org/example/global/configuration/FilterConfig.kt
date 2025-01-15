package org.example.global.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.global.filter.ExceptionFilter
import org.example.global.filter.JwtFilter
import org.example.global.security.jwt.JwtProvider
import org.springframework.security.config.annotation.SecurityConfigurer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig (
    private val jwtProvider: JwtProvider,
    private val objectMapper: ObjectMapper
) : SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity> {
    override fun init(builder: HttpSecurity?) { }

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtFilter(jwtProvider), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(ExceptionFilter(objectMapper), JwtFilter::class.java)
    }
}