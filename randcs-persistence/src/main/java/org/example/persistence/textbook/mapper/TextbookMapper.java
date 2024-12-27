package org.example.persistence.textbook.mapper;

import lombok.RequiredArgsConstructor;
import org.example.domain.textbook.model.Textbook;
import org.example.persistence.GenericMapper;
import org.example.persistence.textbook.entity.TextbookJpaEntity;
import org.example.persistence.user.entity.UserJpaEntity;
import org.example.persistence.user.repository.UserJpaRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class TextbookMapper implements GenericMapper<Textbook, TextbookJpaEntity> {
    private final UserJpaRepository userJpaRepository;

    @Override
    public TextbookJpaEntity toEntity(Textbook domain) {
        UserJpaEntity userEntity = userJpaRepository.findById(domain.getUserEmail())
                .orElseThrow(RuntimeException::new);

        return new TextbookJpaEntity(
                domain.getId(),
                userEntity,
                domain.getCoverImage(),
                domain.getTitle()
        );
    }

    @Override
    public Optional<Textbook> toDomain(Optional<TextbookJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        TextbookJpaEntity textbookEntity = entity.get();

        return Optional.of(Textbook.builder()
                .id(textbookEntity.getId())
                .userEmail(textbookEntity.getUser().getEmail())
                .title(textbookEntity.getTitle())
                .coverImage(textbookEntity.getCoverImage())
                .build()
        );
    }
}
