package org.example.domain.auth.dto.resposne;

public record LoginResponseDto(
        String access,
        String refresh,
        String profile
) {
}
