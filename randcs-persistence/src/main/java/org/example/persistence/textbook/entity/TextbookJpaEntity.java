package org.example.persistence.textbook.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.persistence.user.entity.UserJpaEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Getter
@Entity(name = "textbook")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TextbookJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID textbookId;

    @ManyToOne(targetEntity = UserJpaEntity.class, optional = true)
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserJpaEntity user;

    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    @ColumnDefault("'BASE_COVER_IMAGE_URL'")
    private String coverImage;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String title;
}
