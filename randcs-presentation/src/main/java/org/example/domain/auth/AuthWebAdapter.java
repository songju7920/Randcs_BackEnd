package org.example.domain.auth;

import lombok.RequiredArgsConstructor;
import org.example.common.annotation.WebAdapter;
import org.example.domain.auth.dto.request.LoginRequestDto;
import org.example.domain.auth.dto.request.SignupRequestDto;
import org.example.domain.auth.usecase.DeleteUserUseCase;
import org.example.domain.auth.usecase.LoginUseCase;
import org.example.domain.auth.usecase.SignupUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@WebAdapter
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthWebAdapter {
    private final SignupUseCase signupUseCase;
    private final LoginUseCase loginUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequestDto request) {
        signupUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public void login(@RequestBody LoginRequestDto request) {
        loginUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteUser() {
        deleteUserUseCase.execute();
    }
}
