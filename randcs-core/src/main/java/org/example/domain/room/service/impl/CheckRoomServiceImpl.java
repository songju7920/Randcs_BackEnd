package org.example.domain.room.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.room.exception.RoomAlreadyExistsException;
import org.example.domain.room.exception.RoomNotExistsException;
import org.example.domain.room.service.CheckRoomService;
import org.example.domain.room.spi.QueryRoomPort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckRoomServiceImpl implements CheckRoomService {
    private final QueryRoomPort queryRoomPort;

    @Override
    public void checkAlreadyExistByUser(User user) {
        if (queryRoomPort.existsByUser(user)) {
            throw RoomAlreadyExistsException.EXCEPTION;
        };
    }

    @Override
    public void checkExistByRoomId(UUID roomId) {
        if (!queryRoomPort.existsByRoomId(roomId)) {
            throw RoomNotExistsException.EXCEPTION;
        }
    }
}
