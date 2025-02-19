package org.example.persistence.room.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.domain.room.entity.RoomType;
import org.example.persistence.textbook.entity.TextbookJpaEntity;
import org.example.persistence.user.entity.UserJpaEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Getter
@Entity(name = "room")
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID roomId;

    @OneToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserJpaEntity user;

    @OneToOne(targetEntity = TextbookJpaEntity.class, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "textbookId", referencedColumnName = "textbookId", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TextbookJpaEntity textbook;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType mode;
}
