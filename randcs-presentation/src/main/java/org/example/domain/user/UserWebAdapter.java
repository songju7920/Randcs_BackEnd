package org.example.domain.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.dto.request.UpdatePasswordRequestDto;
import org.example.domain.user.dto.request.UpdateUserProfileRequestDto;
import org.example.domain.user.dto.response.GetUserProfileResponseDto;
import org.example.domain.user.usecase.GetUserProfileUseCase;
import org.example.domain.user.usecase.UpdatePasswordUseCase;
import org.example.domain.user.usecase.UpdateUserProfileUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserWebAdapter {
    private final GetUserProfileUseCase getUserProfileUseCase;
    private final UpdateUserProfileUseCase updateUserProfileUseCase;
    private final UpdatePasswordUseCase updatePasswordUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/profile")
    public GetUserProfileResponseDto getUserProfile() {
        return getUserProfileUseCase.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/profile")
    public void updateUserProfile(@Validated @RequestBody UpdateUserProfileRequestDto request) {
        updateUserProfileUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/password")
    public void updatePassword(@Validated @RequestBody UpdatePasswordRequestDto request) {
        updatePasswordUseCase.execute(request);
    }
}
