package org.example.common.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.common.spi.SecurityPort;
import org.example.domain.user.excetpion.UserNotFoundException;
import org.example.domain.user.model.User;
import org.example.domain.user.spi.QueryUserPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentUserProviderImpl implements CurrentUserProvider {
    private final SecurityPort securityPort;
    private final QueryUserPort queryUserPort;

    @Override
    public String getCurrentUserEmail() {
        return securityPort.getCurrentUserEmail();
    }

    @Override
    public User getCurruntUser() {
        return queryUserPort.getUserByEmail(this.getCurrentUserEmail()).orElseThrow(
                () -> UserNotFoundException.EXCEPTION
        );
    }
}
