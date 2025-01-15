package org.example.global.security.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails (
   val email: String
): UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? = null
    override fun getPassword(): String? = null
    override fun getUsername(): String? = null
}