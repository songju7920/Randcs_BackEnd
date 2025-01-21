package org.example.global.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.example.common.spi.JwtPort;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtAdapter implements JwtPort {
    private final JwtProperties jwtProperties;

    @Override
    public String generateAccess(String email) {
        Long now = new Date().getTime();
        Date accessExpireAt = new Date(now + jwtProperties.accessExpireTime());

        return Jwts.builder()
                .setSubject(email)
                .claim("type", "access")
                .setExpiration(accessExpireAt)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret())
                .compact();
    }

    @Override
    public String generateRefresh(String email) {
        Long now = new Date().getTime();
        Date refreshExpireAt = new Date(now + jwtProperties.refreshExpireTime());

        return Jwts.builder()
                .setSubject(email)
                .claim("type", "refresh")
                .setExpiration(refreshExpireAt)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret())
                .compact();
    }
}
