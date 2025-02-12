package org.example.domain.room.dto.request;

import org.example.common.annotation.ValidEnum;
import org.example.domain.room.entity.RoomType;

import java.util.UUID;

public record CreateRoomRequestDto (
        @ValidEnum RoomType roomType,
        UUID textBookId
) {
}
