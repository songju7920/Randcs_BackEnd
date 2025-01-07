package org.example.persistence.user.repository;

import org.example.persistence.user.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserJpaRepository extends CrudRepository<UserJpaEntity, String> {
    Optional<UserJpaEntity> findByEmail(String email);
}
