package org.example.persistence.room;

import lombok.RequiredArgsConstructor;
import org.example.domain.room.entity.Room;
import org.example.domain.room.spi.QueryRoomPort;
import org.example.domain.user.model.User;
import org.example.persistence.room.mapper.RoomMapper;
import org.example.persistence.room.repository.RoomJpaRepository;
import org.example.persistence.user.entity.UserJpaEntity;
import org.example.persistence.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RoomPersistenceAdapter implements QueryRoomPort {
    private final RoomJpaRepository roomJpaRepository;
    private final RoomMapper roomMapper;
    private final UserMapper userMapper;

    @Override
    public Room saveRoom(Room room) {
        return roomMapper.toDomain(
            Optional.of(roomJpaRepository.save(
                roomMapper.toEntity(room)
            ))
        ).get();
    }

    @Override
    public void deleteRoom(Room room) {
        roomJpaRepository.delete(
                roomMapper.toEntity(room)
        );
    }

    @Override
    public Boolean existsByUser(User user) {
        return roomJpaRepository.existsByUser(
                userMapper.toEntity(user)
        );
    }

    @Override
    public Optional<Room> getRoomByUser(User user) {
        UserJpaEntity userEntity = userMapper.toEntity(user);

        return roomMapper.toDomain(
                roomJpaRepository.findByUser(userEntity)
        );
    }

    @Override
    public boolean existsByRoomId(UUID roomId) {
        return roomJpaRepository.existsById(roomId);
    }
}
