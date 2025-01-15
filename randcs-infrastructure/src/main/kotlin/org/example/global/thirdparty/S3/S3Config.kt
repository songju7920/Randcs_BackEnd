package org.example.global.thirdparty.S3

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class S3Config {
    @Value("\${cloud.aws.credentials.access-key}")
    var accessKey: String? = null

    @Value("\${cloud.aws.credentials.secret-key}")
    var secretKey: String? = null

    @Bean
    open fun amazonS3Client(): AmazonS3Client {
        val awsCredentials = BasicAWSCredentials(accessKey, secretKey)
        return AmazonS3ClientBuilder.standard()
                .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
                .withRegion("ap-northeast-2")
                .build() as AmazonS3Client
    }
}
