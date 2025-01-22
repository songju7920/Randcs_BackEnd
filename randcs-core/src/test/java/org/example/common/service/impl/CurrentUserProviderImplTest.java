package org.example.common.service.impl;

import org.example.common.spi.SecurityPort;
import org.example.domain.user.excetpion.UserNotFoundException;
import org.example.domain.user.excetpion.errorCode.UserErrorCode;
import org.example.domain.user.spi.QueryUserPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CurrentUserProviderImplTest {
    @Mock SecurityPort securityPort;
    @Mock QueryUserPort queryUserPort;
    @InjectMocks CurrentUserProviderImpl userProvider;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("User Not Found Exception 정상작동 확인")
    void userNotFoundExceptionWorks() {
        String email = "email@gmail.com";

        when(securityPort.getCurrentUserEmail()).thenReturn(email);
        when(queryUserPort.getUserByEmail(email)).thenReturn(Optional.empty());

        // test
        UserNotFoundException exception = assertThrows(
                UserNotFoundException.class,
                () -> userProvider.getCurruntUser()
        );

        // verify
        assertEquals(UserErrorCode.USER_NOT_FOUND, exception.errorCode);
    }
}