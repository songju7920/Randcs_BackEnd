package org.example.domain.user.spi;

import org.example.domain.user.model.User;

import java.util.Optional;

public interface QueryUserPort {

    Optional<User> getUserByEmail(String email);
}
