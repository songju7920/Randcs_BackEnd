package org.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.user.dto.response.GetUserProfileResponseDto;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetUserProfileUseCase {
    private final CurrentUserProvider currentUserProvider;

    public GetUserProfileResponseDto execute() {
        User user = currentUserProvider.getCurruntUser();

        return GetUserProfileResponseDto.from(user);
    }
}
