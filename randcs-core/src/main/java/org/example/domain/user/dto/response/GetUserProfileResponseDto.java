package org.example.domain.user.dto.response;

import org.example.domain.user.model.User;

import java.math.BigInteger;

public record GetUserProfileResponseDto(
        String nickname,
        String profile,
        String job,
        String office,
        String url,
        BigInteger exp
) {
    public static GetUserProfileResponseDto from(User user) {
        return new GetUserProfileResponseDto(
                user.getNickname(),
                user.getProfile(),
                user.getJob().orElse(null),
                user.getOffice().orElse(null),
                user.getUrl().orElse(null),
                user.getExp()
        );
    }
}
