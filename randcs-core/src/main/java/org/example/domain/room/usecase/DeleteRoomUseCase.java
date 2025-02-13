package org.example.domain.room.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.room.entity.Room;
import org.example.domain.room.service.CommandRoomService;
import org.example.domain.room.service.GetRoomService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteRoomUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetRoomService getRoomService;
    private final CommandRoomService commandRoomService;

    public void execute() {
        User user = currentUserProvider.getCurruntUser();

        Room room = getRoomService.getRoomByUser(user);

        commandRoomService.deleteRoom(room);
    }
}
