package org.example.persistence.problem.mapper;

import lombok.RequiredArgsConstructor;
import org.example.domain.problem.model.Problem;
import org.example.persistence.GenericMapper;
import org.example.persistence.problem.entity.ProblemJpaEntity;
import org.example.domain.problem.model.ProblemType;
import org.example.persistence.textbook.entity.TextbookJpaEntity;
import org.example.persistence.textbook.repository.TextbookJpaRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class ProblemMapper implements GenericMapper<Problem, ProblemJpaEntity> {
    private final TextbookJpaRepository textbookRepository;

    @Override
    public ProblemJpaEntity toEntity(Problem domain) {
        TextbookJpaEntity textbookEntity = textbookRepository.findById(domain.getTextbookId())
                .orElseThrow(RuntimeException::new);

        return new ProblemJpaEntity(
                domain.getProblemId(),
                textbookEntity,
                domain.getContext(),
                ProblemType.valueOf(domain.getType()),
                domain.getChoice()
        );
    }

    @Override
    public Optional<Problem> toDomain(Optional<ProblemJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        ProblemJpaEntity problemEntity = entity.get();

        return Optional.of(Problem.builder()
                .problemId(problemEntity.getProblemId())
                .textbookId(problemEntity.getTextbook().getTextbookId())
                .context(problemEntity.getContext())
                .type(problemEntity.getType().name())
                .choice(problemEntity.getChoice())
                .build()
        );
    }
}
