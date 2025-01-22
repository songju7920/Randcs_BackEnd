package org.example.domain.user.spi;

import org.example.domain.user.model.User;

import java.util.Optional;

public interface QueryUserPort {

    void saveUser(User user);

    void deleteUser(User user);

    Optional<User> getUserByEmail(String email);

    Boolean checkUserExistsByEmail(String email);
}
