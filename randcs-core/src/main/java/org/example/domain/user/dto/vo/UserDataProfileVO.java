package org.example.domain.user.dto.vo;

import org.example.domain.user.model.User;

import java.math.BigInteger;

public record UserDataProfileVO(
        String nickname,
        String profile,
        String job,
        String office,
        String url,
        BigInteger exp
) {
    public static UserDataProfileVO of(User user) {
        return new UserDataProfileVO(
                user.getNickname(),
                user.getProfile(),
                user.getJob().orElse(null),
                user.getOffice().orElse(null),
                user.getUrl().orElse(null),
                user.getExp()
        );
    }
}
