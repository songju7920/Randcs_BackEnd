package org.example.global.thirdparty.ollama.dto.response;

import java.time.LocalDateTime;

public record OllamaPromptResponseDto(
        String model,
        LocalDateTime created_at,
        String response,
        Boolean done
) {
}
