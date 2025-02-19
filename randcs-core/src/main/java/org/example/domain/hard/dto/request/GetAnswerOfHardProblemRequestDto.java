package org.example.domain.hard.dto.request;

public record GetAnswerOfHardProblemRequestDto(
        String problem,
        String answer
) {
}
