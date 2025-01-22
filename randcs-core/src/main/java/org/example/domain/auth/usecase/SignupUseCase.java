package org.example.domain.auth.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.annotation.MutableUseCase;
import org.example.common.service.SecurityService;
import org.example.domain.auth.dto.request.SignupRequestDto;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CheckUserService;
import org.example.domain.user.service.CommandUserService;

import java.util.Optional;

@MutableUseCase
@RequiredArgsConstructor
public class SignupUseCase {
    private final CommandUserService commandUserService;
    private final CheckUserService checkUserService;
    private final SecurityService securityService;

    public void execute(SignupRequestDto request) {
        checkUserService.checkUserAlreadyExistsByEmail(request.email());

        String encryptedPassword = securityService.encodePassword(request.password());

        commandUserService.saveUser(User.builder()
                .email(request.email())
                .nickname(request.nickname())
                .password(encryptedPassword)
                .profile(request.profile())
                .url(Optional.ofNullable(request.url()))
                .job(Optional.ofNullable(request.job()))
                .office(Optional.ofNullable(request.office()))
                .build()
        );
    }
}
