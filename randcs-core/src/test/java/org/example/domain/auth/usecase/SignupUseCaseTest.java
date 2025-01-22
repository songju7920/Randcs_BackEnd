package org.example.domain.auth.usecase;

import org.example.common.service.SecurityService;
import org.example.domain.auth.dto.request.SignupRequestDto;
import org.example.domain.user.excetpion.EmailAlreadyExistsException;
import org.example.domain.user.excetpion.errorCode.UserErrorCode;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CheckUserService;
import org.example.domain.user.service.CommandUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SignupUseCaseTest {
    @Mock CommandUserService commandUserService;
    @Mock CheckUserService checkUserService;
    @Mock SecurityService securityService;
    @InjectMocks SignupUseCase signupUseCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("로직이 정상적으로 흘러가는지에 대한 테스트")
    void logicWorksNormally() {
        String email = "email@gmail.com";
        String rawPassword = "rawPassword";
        SignupRequestDto request = makeSignupRequestDtoByEmailAndPassword(email, rawPassword);

        doNothing().when(checkUserService).checkUserAlreadyExistsByEmail(email);
        when(securityService.encodePassword(rawPassword)).thenReturn("encodedPassword");

        // test
        signupUseCase.execute(request);

        // verify
        verify(checkUserService).checkUserAlreadyExistsByEmail(email);
        verify(securityService).encodePassword(rawPassword);
    }

    @Test
    @DisplayName("이미 가입된 이메일시 제대로 예외처리 발생하는지")
    void checkEmailAlreadyExistsExceptionWorks() {
        String email = "email@gmail.com";
        String rawPassword = "rawPassword";
        SignupRequestDto request = makeSignupRequestDtoByEmailAndPassword(email, rawPassword);


        doThrow(EmailAlreadyExistsException.EXCEPTION).when(checkUserService).checkUserAlreadyExistsByEmail(email);
        when(securityService.encodePassword(rawPassword)).thenReturn("encodedPassword");

        // test
        EmailAlreadyExistsException exception = assertThrows(
                EmailAlreadyExistsException.class,
                () -> signupUseCase.execute(request)
        );

        // verify
        verify(checkUserService).checkUserAlreadyExistsByEmail(email);
        verify(securityService, never()).encodePassword(rawPassword);
        assertEquals(UserErrorCode.EMAIL_ALREADY_EXISTS, exception.errorCode);
    }

    private SignupRequestDto makeSignupRequestDtoByEmailAndPassword(String email, String password) {
        SignupRequestDto request = new SignupRequestDto(
                email, // email
                "nickname", // nickname
                password, // password
                "profile_url", // profile
                null, // job
                null, // office
                "url" // url
        );
    }
}