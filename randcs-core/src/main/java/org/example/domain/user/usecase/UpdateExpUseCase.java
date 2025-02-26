package org.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.user.dto.request.UpdateExpRequestDto;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateExpUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandUserService commandUserService;

    public void execute(@RequestBody UpdateExpRequestDto request) {
        User user = currentUserProvider.getCurruntUser();

        commandUserService.saveUser(User.builder()
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .password(user.getPassword())
                    .profile(user.getProfile())
                    .job(user.getJob())
                    .office(user.getOffice())
                    .url(user.getUrl())
                    .tel(user.getTel())
                    .exp(user.getExp().add(BigInteger.valueOf(request.exp())))
                    .build());
    }
}
