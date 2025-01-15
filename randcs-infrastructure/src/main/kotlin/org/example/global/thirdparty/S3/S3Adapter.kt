package org.example.global.thirdparty.S3

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.ObjectMetadata
import lombok.extern.slf4j.Slf4j
import org.example.common.service.FileStorageService
import org.example.global.exception.generalExceptions.InternalServerErrorException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Slf4j
@Component
class S3Adapter(
    private val amazonS3Client: AmazonS3Client
) : FileStorageService {

    @Value("\${cloud.aws.bucket-name}")
    var bucketName: String? = null

    override fun uploadFile(file: MultipartFile) {
        try {
            val name = UUID.randomUUID().toString() + file.originalFilename

            val metadata = ObjectMetadata()
            metadata.contentLength = file.size
            metadata.contentType = file.contentType

            amazonS3Client.putObject(bucketName, name, file.inputStream, metadata)
        } catch (e: Exception) {
            e.printStackTrace()
            throw InternalServerErrorException
        }
    }
}
