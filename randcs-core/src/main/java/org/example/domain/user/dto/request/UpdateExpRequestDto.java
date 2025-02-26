package org.example.domain.user.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateExpRequestDto(
        @NotNull Integer exp
) {
}
