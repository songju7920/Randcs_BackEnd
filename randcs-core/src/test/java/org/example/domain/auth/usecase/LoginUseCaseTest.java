package org.example.domain.auth.usecase;

import org.example.common.service.SecurityService;
import org.example.domain.auth.dto.request.LoginRequestDto;
import org.example.domain.user.excetpion.UserNotFoundException;
import org.example.domain.user.model.User;
import org.example.domain.user.service.GetUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class LoginUseCaseTest {
    @Mock private GetUserService getUserService;
    @Mock private SecurityService securityService;
    @InjectMocks private LoginUseCase loginUseCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("정상적으로 로직이 흘러가는지에 대한 테스트")
    void testLoginSuccess() {
        String email = "test@gmail.com";
        String password = "password123";
        String encryptedPassword = "encryptedPassword";
        User mockedUser = User.builder()
                .email(email)
                .password(encryptedPassword)
                .build();

        LoginRequestDto request = new LoginRequestDto(email, password);

        // mock config
        when(getUserService.getUserByEmail(email)).thenReturn(mockedUser);
        doNothing().when(securityService).checkPasswordMatches(password, encryptedPassword);

        // test
        loginUseCase.execute(request);

        // verify
        verify(getUserService).getUserByEmail(email);
        verify(securityService).checkPasswordMatches(password, encryptedPassword);
    }
}