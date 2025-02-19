package org.example.domain.hard.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.OllamaService;
import org.example.common.util.AIRequestPrompts;
import org.example.common.util.JsonConvertor;
import org.example.domain.hard.dto.response.GetHardProblemResponseDto;
import org.example.domain.room.service.CheckRoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetHardProblemUseCase {
    private final OllamaService ollamaService;
    private final CheckRoomService checkRoomService;

    public GetHardProblemResponseDto execute(UUID roomId) {
        checkRoomService.checkExistByRoomId(roomId);

        String jsonResponse = ollamaService.sendPrompt(AIRequestPrompts.getHardProblemPrompt);
        Map response = JsonConvertor.convertJsonToMap(jsonResponse);

        return new GetHardProblemResponseDto(response.get("problem").toString());
    }
}
