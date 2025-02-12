package org.example.persistence.room.mapper;

import lombok.RequiredArgsConstructor;
import org.example.domain.room.entity.Room;
import org.example.persistence.GenericMapper;
import org.example.persistence.room.entity.RoomJpaEntity;
import org.example.persistence.textbook.entity.TextbookJpaEntity;
import org.example.persistence.textbook.repository.TextbookJpaRepository;
import org.example.persistence.user.entity.UserJpaEntity;
import org.example.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RoomMapper implements GenericMapper<Room, RoomJpaEntity> {
    private final UserJpaRepository userJpaRepository;
    private final TextbookJpaRepository textbookJpaRepository;

    @Override
    public RoomJpaEntity toEntity(Room domain) {
        UserJpaEntity userEntity = userJpaRepository.findById(domain.getEmail())
                .orElse(null);

        TextbookJpaEntity textbookEntity = textbookJpaRepository.findById(domain.getTextBookId().orElse(new UUID(0, 0)))
                .orElse(null);

        return new RoomJpaEntity(
                domain.getRoomId(),
                userEntity,
                textbookEntity,
                domain.getMode()
        );
    }

    @Override
    public Optional<Room> toDomain(Optional<RoomJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        RoomJpaEntity roomEntity = entity.get();

        return Optional.of(Room.builder()
                    .roomId(roomEntity.getRoomId())
                    .email(roomEntity.getUser().getEmail())
                    .mode(roomEntity.getMode())
                    .build()
        );
    }
}
