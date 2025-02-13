package org.example.domain.room;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.room.dto.request.CreateRoomRequestDto;
import org.example.domain.room.dto.response.CreateRoomResponseDto;
import org.example.domain.room.usecase.CreateRoomUseCase;
import org.example.domain.room.usecase.DeleteRoomUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomWebAdapter {
    private final CreateRoomUseCase createRoomUseCase;
    private final DeleteRoomUseCase deleteRoomUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateRoomResponseDto createRoom(@Valid @RequestBody CreateRoomRequestDto request) {
        return createRoomUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteRoom() {
        deleteRoomUseCase.execute();
    }
}
