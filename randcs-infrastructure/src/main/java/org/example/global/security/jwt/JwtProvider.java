package org.example.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.common.error.exception.InternalServerErrorException;
import org.example.global.security.auth.CustomUserDetails;
import org.example.global.security.auth.CustomUserDetailsService;
import org.example.global.security.exception.ExpiredTokenException;
import org.example.global.security.exception.TokenNotValidException;
import org.example.global.security.exception.errorCode.TokenIsNotAccessException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;
    private final CustomUserDetailsService customUserDetailsService;

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);

        if (claims.get("type").equals("access")) {
            throw TokenIsNotAccessException.EXCEPTION;
        }

        CustomUserDetails userDetails = customUserDetailsService.loadUserByEmail(claims.getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails.email(), "", null);
    }

    public Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.secret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InternalServerErrorException.Exception;
        }

    }

    public String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader(jwtProperties.header());

        if (!token.isEmpty() && token.startsWith(jwtProperties.prefix()) && token.length() > 7) {
            return token.split(" ")[1];
        } else {
            throw TokenNotValidException.EXCEPTION;
        }
    }
}
