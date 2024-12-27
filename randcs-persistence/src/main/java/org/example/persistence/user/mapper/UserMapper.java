package org.example.persistence.user.mapper;

import org.example.domain.user.model.User;
import org.example.persistence.GenericMapper;
import org.example.persistence.user.entity.UserJpaEntity;

import java.util.Optional;

public class UserMapper implements GenericMapper<User, UserJpaEntity> {

    @Override
    public UserJpaEntity toEntity(User domain) {
        return new UserJpaEntity(
                domain.getEmail(),
                domain.getNickname(),
                domain.getPassword(),
                domain.getProfile(),
                domain.getJob().orElse(null),
                domain.getOffice().orElse(null),
                domain.getUrl().orElse(null),
                domain.getTel().orElse(null),
                domain.getExp()
        );
    }

    @Override
    public Optional<User> toDomain(Optional<UserJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        UserJpaEntity userEntity = entity.get();

        return Optional.of(User.builder()
                .email(userEntity.getEmail())
                .nickname(userEntity.getNickname())
                .password(userEntity.getPassword())
                .profile(userEntity.getProfile())
                .job(Optional.ofNullable(userEntity.getJob()))
                .office(Optional.ofNullable(userEntity.getOffice()))
                .url(Optional.ofNullable(userEntity.getUrl()))
                .tel(Optional.ofNullable(userEntity.getTel()))
                .exp(userEntity.getExp())
                .build()
        );
    }
}
