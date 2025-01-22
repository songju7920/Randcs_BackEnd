package org.example.domain.user.service;

import org.example.domain.user.model.User;

public interface CommandUserService {

    void saveUser(User user);

    void deleteUser(User user);
}
