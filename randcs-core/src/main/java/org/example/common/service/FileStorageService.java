package org.example.common.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    void uploadFile(MultipartFile file);
}
