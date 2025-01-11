package org.example.persistence.room.repository;

import org.example.persistence.room.entity.RoomJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoomJpaRepository extends CrudRepository<RoomJpaEntity, UUID> {
}
