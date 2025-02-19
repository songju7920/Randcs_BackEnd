package org.example.domain.hard;

import lombok.RequiredArgsConstructor;
import org.example.domain.hard.dto.request.GetAnswerOfHardProblemRequestDto;
import org.example.domain.hard.dto.response.GetAnswerOfHardProblemResponseDto;
import org.example.domain.hard.dto.response.GetHardProblemResponseDto;
import org.example.domain.hard.usecase.GetAnswerOfHardProblemUseCase;
import org.example.domain.hard.usecase.GetHardProblemUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/hard")
@RequiredArgsConstructor
public class HardWebAdapter {
    private final GetHardProblemUseCase getHardProblemUseCase;
    private final GetAnswerOfHardProblemUseCase getAnswerOfHardProblemUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{roomId}")
    public GetHardProblemResponseDto getHardProblem(@PathVariable UUID roomId) {
        return getHardProblemUseCase.execute(roomId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/answer/{roomId}")
    public GetAnswerOfHardProblemResponseDto getAnswerOfHardProblem(@PathVariable UUID roomId, @RequestBody GetAnswerOfHardProblemRequestDto request) {
        return getAnswerOfHardProblemUseCase.execute(roomId, request);
    }
}
