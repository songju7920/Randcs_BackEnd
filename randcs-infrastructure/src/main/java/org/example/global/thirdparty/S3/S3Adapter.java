package org.example.global.thirdparty.S3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.common.error.exception.InternalServerErrorException;
import org.example.common.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class S3Adapter implements FileStorageService {
    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.bucket-name}")
    String bucketName;

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            String name = UUID.randomUUID() + file.getOriginalFilename();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            amazonS3Client.putObject(bucketName, name, file.getInputStream(), metadata);

            return amazonS3Client.getResourceUrl(bucketName, name);
        } catch (Exception e) {
            log.error("S3 파일 업로드 과정에서 에러 발생");
            throw InternalServerErrorException.EXCEPTION;
        }
    }
}
