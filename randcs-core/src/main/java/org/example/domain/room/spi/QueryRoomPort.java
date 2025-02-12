package org.example.domain.room.spi;

import org.example.domain.room.entity.Room;
import org.example.domain.user.model.User;

public interface QueryRoomPort {

    Room saveRoom(Room room);

    Boolean existsByUser(User user);
}
