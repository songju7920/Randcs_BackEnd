package org.example.domain.room.service;

import org.example.domain.user.model.User;

public interface CheckRoomService {

    void checkAlreadyExistByUser(User user);
}
