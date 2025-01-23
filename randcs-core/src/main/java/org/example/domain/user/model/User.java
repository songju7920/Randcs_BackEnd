package org.example.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Optional;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class User {
    private final String email;

    private final String nickname;

    private final String password;

    @Builder.Default
    private final String profile = "DEFAULT_IMG_URL";

    private final Optional<String> job;

    private final Optional<String> office;

    private final Optional<String> url;

    private final Optional<String> tel;

    @Builder.Default
    private final BigInteger exp = BigInteger.valueOf(0);
}
