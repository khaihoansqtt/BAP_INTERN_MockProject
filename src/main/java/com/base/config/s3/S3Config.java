package com.base.config.s3;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class S3Config {

    @Value("${aws.accessKey}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.region}")
    private String regionValue;

    @Bean
    public S3Presigner getAmazonS3Client() {

        Region region = Region.of(regionValue);

        AwsCredentialsProvider credentials = StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey,
                secretKey));
        S3Presigner presigner = S3Presigner.builder()
                .region(region)
                .credentialsProvider(credentials).build();
        return presigner;
    }

//    @Bean
//    public S3Client getS3Client() {
//        return S3Client.builder().build();
//    }
}
