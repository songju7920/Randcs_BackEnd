package org.example.global.security.auth;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {
    public CustomUserDetails loadUserByEmail(String email) {
        return null; // todo: userEntity mapping 완료되면 여기에 관련 로직 추가
    }
}
