package org.example.domain.room.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.room.entity.Room;
import org.example.domain.room.service.CommandRoomService;
import org.example.domain.room.spi.QueryRoomPort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandRoomServiceImpl implements CommandRoomService {
    private final QueryRoomPort queryRoomPort;

    @Override
    public Room saveRoom(Room room) {
        return queryRoomPort.saveRoom(room);
    }
}
