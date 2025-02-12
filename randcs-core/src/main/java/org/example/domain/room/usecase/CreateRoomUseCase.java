package org.example.domain.room.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.room.dto.request.CreateRoomRequestDto;
import org.example.domain.room.dto.response.CreateRoomResponseDto;
import org.example.domain.room.entity.Room;
import org.example.domain.room.service.CheckRoomService;
import org.example.domain.room.service.CommandRoomService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRoomUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandRoomService commandRoomService;
    private final CheckRoomService checkRoomService;

    public CreateRoomResponseDto execute(CreateRoomRequestDto request) {
        User user = currentUserProvider.getCurruntUser();

        checkRoomService.checkAlreadyExistByUser(user);

        Room createdRoom = commandRoomService.saveRoom(Room.builder()
                    .email(user.getEmail())
                    .mode(request.roomType())
                    .textBookId(Optional.ofNullable(request.textBookId()))
                    .build()
        );

        return new CreateRoomResponseDto(createdRoom.getRoomId());
    }
}
