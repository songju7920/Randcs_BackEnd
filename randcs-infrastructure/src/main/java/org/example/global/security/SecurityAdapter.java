package org.example.global.security;

import lombok.RequiredArgsConstructor;
import org.example.common.spi.SecurityPort;
import org.example.domain.user.model.User;
import org.example.global.security.auth.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityAdapter implements SecurityPort {
    @Override
    public String getCurrentUserEmail() {
        return ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).email();
    }
}
