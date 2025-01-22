package org.example.domain.auth.usecase;

import org.example.common.service.CurrentUserProvider;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteUserUseCaseTest {
    @Mock CurrentUserProvider currentUserProvider;
    @Mock CommandUserService commandUserService;
    @InjectMocks DeleteUserUseCase deleteUserUseCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("로직이 정상적으로 흘러가는지 테스트")
    void deleteUseCaseTest() {
        User mockedUser = User.builder()
                .email("email@gmail.com")
                .password("encrypted password")
                .build();

        when(currentUserProvider.getCurruntUser()).thenReturn(mockedUser);
        doNothing().when(commandUserService).deleteUser(mockedUser);

        // test
        deleteUserUseCase.execute();

        // verify
        verify(currentUserProvider).getCurruntUser();
        verify(commandUserService).deleteUser(mockedUser);
    }
}