package org.example.persistence.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.math.BigInteger;

@Getter
@Entity(name = "user")
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpaEntity {
    @Id
    @Column(nullable = false, columnDefinition = "VARCHAR(60)")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(40)")
    private String nickname;

    @Column(nullable = false, columnDefinition = "VARCHAR(225)")
    private String password;

    @ColumnDefault("'BASE_PROFILE_URL'")
    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String profile;

    @Column(nullable = true, columnDefinition = "VARCHAR(30)")
    private String job;

    @Column(nullable = true, columnDefinition = "VARCHAR(30)")
    private String office;

    @Column(nullable = true, columnDefinition = "VARCHAR(70)")
    private String url;

    @Column(nullable = true, columnDefinition = "VARCHAR(20)")
    private String tel;

    @ColumnDefault("0")
    @Column(nullable = false, columnDefinition = "BIGINT")
    private BigInteger exp;
}
