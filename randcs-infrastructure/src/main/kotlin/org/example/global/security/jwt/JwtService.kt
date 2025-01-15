package org.example.global.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.example.common.security.JwtPort
import java.util.*

class JwtService(
    private val jwtProperties: JwtProperties
) : JwtPort {

    override fun generateAccess(email: String): String {
        val now = Date().time
        val accessExpireAt = Date(now + jwtProperties.accessExpireTime)

        return Jwts.builder()
                .setSubject(email)
                .claim("type", "access")
                .setExpiration(accessExpireAt)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
                .compact()
    }

    override fun generateRefresh(email: String): String {
        val now = Date().time
        val refreshExpireAt = Date(now + jwtProperties.refreshExpireTime)

        return Jwts.builder()
                .setSubject(email)
                .claim("type", "refresh")
                .setExpiration(refreshExpireAt)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
                .compact()
    }
}
