package org.example.domain.room.service;

import org.example.domain.user.model.User;

import java.util.UUID;

public interface CheckRoomService {

    void checkAlreadyExistByUser(User user);

    void checkExistByRoomId(UUID roomId);
}
