package org.example.domain.util;

import lombok.RequiredArgsConstructor;
import org.example.domain.util.dto.response.UploadFIleResponseDto;
import org.example.domain.util.usecase.UploadFileUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/util")
@RequiredArgsConstructor
public class UtilWebAdapter {
    private final UploadFileUseCase uploadFileUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/file")
    public UploadFIleResponseDto uploadFile(@RequestPart("file") MultipartFile file) {
        return uploadFileUseCase.execute(file);
    }
}
