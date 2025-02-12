package org.example.persistence.room.repository;

import org.example.persistence.room.entity.RoomJpaEntity;
import org.example.persistence.user.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoomJpaRepository extends CrudRepository<RoomJpaEntity, UUID> {
    Boolean existsByUser(UserJpaEntity entity);
}
