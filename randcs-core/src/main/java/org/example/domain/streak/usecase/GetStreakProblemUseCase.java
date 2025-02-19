package org.example.domain.streak.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.OllamaService;
import org.example.common.util.AIRequestPrompts;
import org.example.common.util.JsonConvertor;
import org.example.domain.room.service.CheckRoomService;
import org.example.domain.streak.dto.response.GetStreakProblemResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class GetStreakProblemUseCase {
    private final OllamaService ollamaService;
    private final CheckRoomService checkRoomService;

    public GetStreakProblemResponseDto execute(UUID roomId) {
        checkRoomService.checkExistByRoomId(roomId);

        String response = ollamaService.sendPrompt(AIRequestPrompts.streakProblemPrompt);

        Map map = JsonConvertor.convertJsonToMap(response);

        return new GetStreakProblemResponseDto(
                map.get("problem").toString(),
                String.join(",", ((List<String>) map.get("choices"))),
                Integer.parseInt(map.get("answer").toString()),
                map.get("explanation").toString()
        );
    }
}
