package org.example.domain.user.dto.response;

import org.example.domain.user.dto.vo.UserDataProfileVO;

public record GetUserProfileResponseDto(
        UserDataProfileVO data
) {
}
