package org.example.persistence.user.repository;

import org.example.persistence.user.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<UserJpaEntity, String> {
}
