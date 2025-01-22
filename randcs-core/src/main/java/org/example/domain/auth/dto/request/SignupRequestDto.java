package org.example.domain.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record SignupRequestDto(
        @Email String email,
        @NotBlank @Length(min = 3) String nickname,
        @NotBlank @Length(min = 8) String password,
        @NotBlank String profile,
        String job,
        String office,
        String url
) {
}
