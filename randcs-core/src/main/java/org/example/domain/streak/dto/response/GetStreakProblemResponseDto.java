package org.example.domain.streak.dto.response;

public record GetStreakProblemResponseDto(
        String problem,
        String choice,
        int answer,
        String description
) {
}
