package com.base.dto.seminar.adminCreateSeminar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FERequirePresignedUrlResDto {

    @JsonProperty("presigned_url")
    private String presignedUrl;

    @JsonProperty("public_url")
    private String publicUrl;
}
