package org.example.domain.user.service.impl;

import org.example.domain.user.excetpion.EmailAlreadyExistsException;
import org.example.domain.user.excetpion.errorCode.UserErrorCode;
import org.example.domain.user.spi.QueryUserPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CheckUserServiceImplTest {
    @Mock QueryUserPort queryUserPort;
    @InjectMocks CheckUserServiceImpl checkUserService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("이메일 오류 정상적으로 출력하는지에 대한 테스트")
    void shouldThrowEmailAlreadyExistsException() {
        String email = "email@gmail.com";

        when(queryUserPort.checkUserExistsByEmail(email)).thenReturn(true);

        // test
        EmailAlreadyExistsException exception = assertThrows(
                EmailAlreadyExistsException.class,
                () -> checkUserService.checkUserAlreadyExistsByEmail(email)
        );

        // verify
        assertEquals(UserErrorCode.EMAIL_ALREADY_EXISTS, exception.errorCode);
    }
}