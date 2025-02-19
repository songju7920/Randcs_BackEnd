package org.example.domain.hard.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.OllamaService;
import org.example.common.util.AIRequestPrompts;
import org.example.common.util.JsonConvertor;
import org.example.domain.hard.dto.request.GetAnswerOfHardProblemRequestDto;
import org.example.domain.hard.dto.response.GetAnswerOfHardProblemResponseDto;
import org.example.domain.room.service.CheckRoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAnswerOfHardProblemUseCase {
    private final OllamaService ollamaService;
    private final CheckRoomService checkRoomService;

    public GetAnswerOfHardProblemResponseDto execute(UUID roomId, GetAnswerOfHardProblemRequestDto request) {
        checkRoomService.checkExistByRoomId(roomId);

        String jsonResponse = ollamaService.sendPrompt(AIRequestPrompts.getCheckProblemAnswerPrompt(request.problem(), request.answer()));
        Map response = JsonConvertor.convertJsonToMap(jsonResponse);

        return new GetAnswerOfHardProblemResponseDto(response.get("result").equals("True"), response.get("message").toString());
    }
}
