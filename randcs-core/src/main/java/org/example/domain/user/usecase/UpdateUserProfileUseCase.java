package org.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.user.dto.request.UpdateUserProfileRequestDto;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateUserProfileUseCase {
    private final CommandUserService commandUserService;
    private final CurrentUserProvider currentUserProvider;

    public void execute(UpdateUserProfileRequestDto request) {
        User user = currentUserProvider.getCurruntUser();

        commandUserService.saveUser(User.builder()
                    .email(user.getEmail())
                    .nickname(request.nickname())
                    .password(user.getPassword())
                    .profile(request.profile())
                    .job(Optional.ofNullable(request.job()))
                    .office(Optional.ofNullable(request.office()))
                    .url(Optional.ofNullable(request.url()))
                    .exp(user.getExp())
                    .tel(user.getTel())
                    .build()
        );
    }
}
