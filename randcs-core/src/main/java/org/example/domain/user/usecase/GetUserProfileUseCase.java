package org.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.annotation.ReadOnlyUseCase;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.user.dto.response.GetUserProfileResponseDto;
import org.example.domain.user.dto.vo.UserDataProfileVO;
import org.example.domain.user.model.User;

@ReadOnlyUseCase
@RequiredArgsConstructor
public class GetUserProfileUseCase {
    private final CurrentUserProvider currentUserProvider;

    public GetUserProfileResponseDto execute() {
        User user = currentUserProvider.getCurruntUser();

        return new GetUserProfileResponseDto(UserDataProfileVO.of(user));
    }
}
