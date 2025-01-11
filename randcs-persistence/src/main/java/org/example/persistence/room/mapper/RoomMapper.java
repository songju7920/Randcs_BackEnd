package org.example.persistence.room.mapper;

import org.example.domain.room.entity.Room;
import org.example.persistence.GenericMapper;
import org.example.persistence.room.entity.RoomJpaEntity;

import java.util.Optional;

public class RoomMapper implements GenericMapper<Room, RoomJpaEntity> {

    @Override
    public RoomJpaEntity toEntity(Room domain) {
        return new RoomJpaEntity(
                domain.getRoomId(),
                domain.getEmail(),
                domain.getCorrectCnt(),
                domain.getWrongCnt(),
                domain.getMode()
        );
    }

    @Override
    public Optional<Room> toDomain(Optional<RoomJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        RoomJpaEntity roomEntity = entity.get();

        return Optional.of(Room.builder()
                    .roomId(roomEntity.getRoomId())
                    .email(roomEntity.getEmail())
                    .correctCnt(roomEntity.getCorrectCnt())
                    .wrongCnt(roomEntity.getWrongCnt())
                    .mode(roomEntity.getMode())
                    .build()
        );
    }
}
