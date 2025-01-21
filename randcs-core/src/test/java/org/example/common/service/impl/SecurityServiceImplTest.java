package org.example.common.service.impl;

import org.example.common.error.exception.PasswordMismatchesException;
import org.example.common.error.exception.errorCode.SecurityErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SecurityServiceImplTest {
    @Mock BCryptPasswordEncoder passwordEncoder;
    @InjectMocks SecurityServiceImpl securityService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("비밀번호가 불일치할때 정상적으로 오류가 나는지에 대한 테스트")
    void testPasswordNotMatchesExceptionWorks() {
        String rawPassword = "1234";
        String encryptedPassword = "encrypted_password";

        when(passwordEncoder.matches(rawPassword, encryptedPassword)).thenReturn(false);

        // test
        PasswordMismatchesException exception = assertThrows(
                PasswordMismatchesException.class,
                () -> securityService.checkPasswordMatches(rawPassword, encryptedPassword)
        );

        // verify
        assertEquals(SecurityErrorCode.PASSWORD_MISMATCHES, exception.errorCode);
    }
}