package org.example.domain.room.service;

import org.example.domain.room.entity.Room;
import org.example.domain.user.model.User;

public interface CommandRoomService {

    Room saveRoom(Room room);
}
