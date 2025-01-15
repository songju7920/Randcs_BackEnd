package org.example.global.security.auth

import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService {
    fun loadUserByEmail(email: String?): CustomUserDetails {
        TODO("나중에 구현 예정")
    }
}
