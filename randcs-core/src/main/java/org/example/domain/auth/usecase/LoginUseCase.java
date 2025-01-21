package org.example.domain.auth.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.annotation.ReadOnlyUseCase;
import org.example.common.service.SecurityService;
import org.example.domain.auth.dto.request.LoginRequestDto;
import org.example.domain.user.model.User;
import org.example.domain.user.service.GetUserService;

@ReadOnlyUseCase
@RequiredArgsConstructor
public class LoginUseCase {
    private final GetUserService getUserService;
    private final SecurityService securityService;

    public void execute(LoginRequestDto request) {
        User user = getUserService.getUserByEmail(request.email());

        securityService.checkPasswordMatches(request.password(), user.getPassword());
    }
}
