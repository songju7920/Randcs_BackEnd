package org.example.domain.user.service.impl;

import org.example.domain.user.excetpion.UserNotFoundException;
import org.example.domain.user.excetpion.errorCode.UserErrorCode;
import org.example.domain.user.model.User;
import org.example.domain.user.spi.QueryUserPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetUserServiceImplTest {
    @Mock QueryUserPort queryUserPort;
    @InjectMocks GetUserServiceImpl getUserService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("유저가 존재하지 않을시 정상적으로 에러가 표시되는지에 대한 테스트")
    void testUserNotFoundErrorWorks() {
        String notValidEmail = "email@gmail.com";
        Optional<User> emptyUser = Optional.empty();

        when(queryUserPort.getUserByEmail(notValidEmail)).thenReturn(emptyUser);

        // test
        UserNotFoundException exception = assertThrows(
                UserNotFoundException.class,
                () -> getUserService.getUserByEmail(notValidEmail)
        );

        // verify
        assertEquals(UserErrorCode.USER_NOT_FOUND, exception.errorCode);
    }
}