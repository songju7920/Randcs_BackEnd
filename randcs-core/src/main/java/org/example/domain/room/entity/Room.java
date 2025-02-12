package org.example.domain.room.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Optional;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class Room {

    private final UUID roomId;

    private final Optional<UUID> textBookId;

    private final String email;

    private final int correctCnt;

    private final int wrongCnt;

    private final RoomType mode;
}
