package org.example.persistence.problem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.problem.model.ProblemType;
import org.example.persistence.textbook.entity.TextbookJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Getter
@Entity(name = "problem")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProblemJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(targetEntity = TextbookJpaEntity.class, optional = true)
    @JoinColumn(name = "textbookId", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TextbookJpaEntity textbook;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String context;

    @Enumerated
    @Column(nullable = false)
    private ProblemType type;


    @Column(nullable = false, columnDefinition = "VARCHAR(40)")
    private String choice;
}
