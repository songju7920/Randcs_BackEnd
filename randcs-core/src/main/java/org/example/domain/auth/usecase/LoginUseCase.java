package org.example.domain.auth.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.JwtService;
import org.example.common.service.SecurityService;
import org.example.domain.auth.dto.request.LoginRequestDto;
import org.example.domain.auth.dto.resposne.LoginResponseDto;
import org.example.domain.user.model.User;
import org.example.domain.user.service.GetUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginUseCase {
    private final GetUserService getUserService;
    private final SecurityService securityService;
    private final JwtService jwtService;

    public LoginResponseDto execute(LoginRequestDto request) {
        User user = getUserService.getUserByEmail(request.email());

        securityService.checkPasswordMatches(request.password(), user.getPassword());

        String access = jwtService.generateAccess(request.email());
        String refresh = jwtService.generateRefresh(request.email());

        return new LoginResponseDto(access, refresh, user.getProfile());
    }
}
