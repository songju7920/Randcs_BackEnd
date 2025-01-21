package org.example.common.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.common.error.exception.PasswordMismatchesException;
import org.example.common.service.SecurityService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public void checkPasswordMatches(String rawPassword, String encryptedPassword) {
        if (!passwordEncoder.matches(rawPassword, encryptedPassword)) {
            throw PasswordMismatchesException.Exception;
        }
    }
}
