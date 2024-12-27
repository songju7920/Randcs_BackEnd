package org.example.persistence.textbook.repository;

import org.example.persistence.textbook.entity.TextbookJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TextbookJpaRepository extends CrudRepository<TextbookJpaEntity, UUID> {

}
