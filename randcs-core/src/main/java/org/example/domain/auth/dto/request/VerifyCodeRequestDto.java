package org.example.domain.auth.dto.request;

public record VerifyCodeRequestDto(
        String verification,
        String code
) {
}
