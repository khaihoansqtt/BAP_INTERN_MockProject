package com.base.dto.seminar.adminCreateSeminar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FERequirePresignedUrlReqDto {

    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("folder_path")
    private String folderPath;

    @JsonProperty("image/jpeg")
    private String contentType;
}
