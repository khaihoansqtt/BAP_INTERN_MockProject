package com.base.dto.seminar.s3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PresignedUrlDto {

    @JsonProperty("presigned_url")
    private String presignedUrl;

    @JsonProperty("public_url")
    private String publicUrl;
}
