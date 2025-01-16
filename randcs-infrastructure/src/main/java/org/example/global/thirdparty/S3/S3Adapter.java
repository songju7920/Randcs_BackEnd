package org.example.global.thirdparty.S3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.common.service.FileStorageService;
import org.example.global.exception.generalExceptions.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Adapter implements FileStorageService {
    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.bucket-name}")
    String bucketName;

    @Override
    public void uploadFile(MultipartFile file) {
        try {
            String name = UUID.randomUUID() + file.getOriginalFilename();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            amazonS3Client.putObject(bucketName, name, file.getInputStream(), metadata);
        } catch (Exception e) {
            log.error("S3 파일 업로드 과정에서 에러 발생");
            throw InternalServerErrorException.EXCEPTION;
        }
    }
}
