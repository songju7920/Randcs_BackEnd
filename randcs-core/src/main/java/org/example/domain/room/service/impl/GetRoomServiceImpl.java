package org.example.domain.room.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.room.entity.Room;
import org.example.domain.room.exception.RoomNotExistsException;
import org.example.domain.room.service.GetRoomService;
import org.example.domain.room.spi.QueryRoomPort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetRoomServiceImpl implements GetRoomService {
    private final QueryRoomPort queryRoomPort;

    @Override
    public Room getRoomByUser(User user) {
        return queryRoomPort.getRoomByUser(user).orElseThrow(
                () -> RoomNotExistsException.EXCEPTION
        );
    }
}
