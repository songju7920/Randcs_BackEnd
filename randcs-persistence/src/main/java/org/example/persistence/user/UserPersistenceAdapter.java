package org.example.persistence.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.model.User;
import org.example.domain.user.spi.QueryUserPort;
import org.example.persistence.user.mapper.UserMapper;
import org.example.persistence.user.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements QueryUserPort {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        userJpaRepository.save(
                userMapper.toEntity(user)
        );
    }

    @Override
    public void deleteUser(User user) {
        userJpaRepository.delete(
                userMapper.toEntity(user)
        );
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userMapper.toDomain(userJpaRepository.findByEmail(email));
    }

    @Override
    public Boolean checkUserExistsByEmail(String email) {
        return userJpaRepository.existsById(email);
    }
}
