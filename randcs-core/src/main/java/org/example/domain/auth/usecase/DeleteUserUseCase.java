package org.example.domain.auth.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteUserUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandUserService commandUserService;

    public void execute() {
        User user = currentUserProvider.getCurruntUser();

        commandUserService.deleteUser(user);
    }
}
