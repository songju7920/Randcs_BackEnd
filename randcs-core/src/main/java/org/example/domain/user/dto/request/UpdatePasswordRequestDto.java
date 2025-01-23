package org.example.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UpdatePasswordRequestDto(
        @NotBlank @Length(min = 8) String newPassword,
        @NotBlank @Length(min = 8) String oldPassword
) {
}
