package org.example.domain.user.service;

import org.example.domain.user.model.User;

public interface GetUserService {

    User getUserByEmail(String email);
}
