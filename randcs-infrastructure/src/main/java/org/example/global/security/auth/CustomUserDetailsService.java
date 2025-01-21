package org.example.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.excetpion.UserNotFoundException;
import org.example.domain.user.model.User;
import org.example.domain.user.spi.QueryUserPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService {
    private final QueryUserPort queryUserPort;

    public CustomUserDetails loadUserByEmail(String email) {
        User user = queryUserPort.getUserByEmail(email).orElseThrow(
                () -> UserNotFoundException.EXCEPTION
        );

        return new CustomUserDetails(user.getEmail());
    }
}
