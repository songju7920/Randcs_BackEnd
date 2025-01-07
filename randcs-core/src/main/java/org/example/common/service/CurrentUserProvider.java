package org.example.common.service;

import org.example.domain.user.model.User;

public interface CurrentUserProvider {

    String getCurrentUserEmail();

    User getCurruntUser();
}
