package org.example.domain.streak;

import lombok.RequiredArgsConstructor;
import org.example.domain.streak.dto.response.GetStreakProblemResponseDto;
import org.example.domain.streak.usecase.GetStreakProblemUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/streak")
@RequiredArgsConstructor
public class StreakWebAdapter {
    private final GetStreakProblemUseCase getStreakProblemUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{roomId}")
    public GetStreakProblemResponseDto getStreakProblem(@PathVariable UUID roomId) {
        return getStreakProblemUseCase.execute(roomId);
    }
}
