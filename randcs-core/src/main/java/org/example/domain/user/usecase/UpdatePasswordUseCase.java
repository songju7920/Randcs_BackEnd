package org.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.common.service.SecurityService;
import org.example.domain.user.dto.request.UpdatePasswordRequestDto;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdatePasswordUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandUserService commandUserService;
    private final SecurityService securityService;

    public void execute(UpdatePasswordRequestDto request) {
        User user = currentUserProvider.getCurruntUser();

        securityService.checkPasswordMatches(request.oldPassword(), user.getPassword());
        String encryptedPassword = securityService.encodePassword(request.newPassword());

        commandUserService.saveUser(User.builder()
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .password(encryptedPassword)
                    .profile(user.getProfile())
                    .url(user.getUrl())
                    .office(user.getOffice())
                    .job(user.getJob())
                    .exp(user.getExp())
                    .tel(user.getTel())
                    .build()
        );
    }
}
