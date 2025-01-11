package org.example.persistence.room.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.domain.room.entity.RoomMode;
import org.example.persistence.user.entity.UserJpaEntity;
import org.hibernate.annotations.ColumnDefault;

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
    @JoinColumn(name = "email", referencedColumnName = "email" ,nullable = false)
    private String email;

    @ColumnDefault("0")
    @Column(nullable = false, columnDefinition = "INT")
    private int correctCnt;

    @ColumnDefault("0")
    @Column(nullable = false, columnDefinition = "INT")
    private int wrongCnt;

    @Enumerated
    @Column(nullable = false, columnDefinition = "INT")
    private RoomMode mode;
}
