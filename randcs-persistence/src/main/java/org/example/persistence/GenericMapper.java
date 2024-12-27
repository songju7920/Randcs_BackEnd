package org.example.persistence;

import java.util.Optional;

public interface GenericMapper<D, E> {
    public E toEntity(D domain);

    public Optional<D> toDomain(Optional<E> entity);
}
