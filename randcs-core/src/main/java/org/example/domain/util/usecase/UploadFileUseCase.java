package org.example.domain.util.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.FileStorageService;
import org.example.domain.util.dto.response.UploadFIleResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class UploadFileUseCase {
    private final FileStorageService fileStorageService;

    public UploadFIleResponseDto execute(MultipartFile file) {
        return new UploadFIleResponseDto(fileStorageService.uploadFile(file));
    }
}
