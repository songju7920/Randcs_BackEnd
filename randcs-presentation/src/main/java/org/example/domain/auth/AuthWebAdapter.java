package org.example.domain.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.auth.dto.request.LoginRequestDto;
import org.example.domain.auth.dto.request.SendCodeToEmailRequestDto;
import org.example.domain.auth.dto.request.SignupRequestDto;
import org.example.domain.auth.dto.request.VerifyCodeRequestDto;
import org.example.domain.auth.dto.resposne.LoginResponseDto;
import org.example.domain.auth.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthWebAdapter {
    private final SignupUseCase signupUseCase;
    private final LoginUseCase loginUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final SendCodeToEmailUseCase sendCodeToEmailUseCase;
    private final VerifyCodeUseCase verifyCodeUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@Valid @RequestBody SignupRequestDto request) {
        signupUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto request) {
        return loginUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteUser() {
        deleteUserUseCase.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/code/email")
    public void sendCodeToEmail(@Valid @RequestBody SendCodeToEmailRequestDto request) {
        sendCodeToEmailUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/code/verification")
    public void verifyCode(@Valid @RequestBody VerifyCodeRequestDto request) {
        verifyCodeUseCase.execute(request);
    }
}
