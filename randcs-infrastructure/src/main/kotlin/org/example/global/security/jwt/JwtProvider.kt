package org.example.global.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import jakarta.servlet.http.HttpServletRequest
import org.example.global.exception.generalExceptions.InternalServerErrorException
import org.example.global.security.auth.CustomUserDetailsService
import org.example.global.security.exception.ExpiredTokenException
import org.example.global.security.exception.TokenIsNotAccessException
import org.example.global.security.exception.TokenNotValidException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class JwtProvider(
    private val jwtProperties: JwtProperties,
    private val customUserDetailsService: CustomUserDetailsService
) {

    fun getAuthentication(token: String?): Authentication {
        val claims = getClaims(token)

        if (claims["type"] == "access") {
            throw TokenIsNotAccessException
        }

        val userDetails = customUserDetailsService.loadUserByEmail(claims.subject)
        return UsernamePasswordAuthenticationToken(userDetails.email, "", null)
    }

    fun getClaims(token: String?): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(jwtProperties.secret)
                .parseClaimsJws(token)
                .body
        } catch (e: Exception) {
            when(e) {
                is ExpiredTokenException -> throw ExpiredTokenException
                else -> throw InternalServerErrorException
            }
        }
    }

    fun getTokenFromHeader(request: HttpServletRequest): String {
        val token = request.getHeader(jwtProperties.header)

        if (!token.isEmpty() && token.startsWith(jwtProperties.prefix) && token.length > 7) {
            return token.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
        } else {
            throw TokenNotValidException
        }
    }
}
