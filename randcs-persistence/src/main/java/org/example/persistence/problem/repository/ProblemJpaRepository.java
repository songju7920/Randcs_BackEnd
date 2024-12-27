package org.example.persistence.problem.repository;

import org.example.persistence.problem.entity.ProblemJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProblemJpaRepository extends CrudRepository<ProblemJpaEntity, UUID> {
}
