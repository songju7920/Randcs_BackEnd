package org.example.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UpdateUserProfileRequestDto(
        @NotBlank @Length(min = 3) String nickname,
        @NotBlank String profile,
        String job,
        String office,
        String url
) {
}
