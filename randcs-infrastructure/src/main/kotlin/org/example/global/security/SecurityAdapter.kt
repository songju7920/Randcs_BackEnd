package org.example.global.security

import org.example.common.spi.SecurityPort
import org.example.global.security.auth.CustomUserDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class SecurityAdapter : SecurityPort {

    override fun getCurrentUserEmail(): String {
        return (SecurityContextHolder.getContext().authentication.principal as CustomUserDetails).email
    }
}
