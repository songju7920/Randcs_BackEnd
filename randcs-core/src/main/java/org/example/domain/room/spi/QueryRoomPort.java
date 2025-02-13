package org.example.domain.room.spi;

import org.example.domain.room.entity.Room;
import org.example.domain.user.model.User;

import java.util.Optional;

public interface QueryRoomPort {

    Room saveRoom(Room room);

    void deleteRoom(Room room);

    Boolean existsByUser(User user);

    Optional<Room> getRoomByUser(User user);
}
