package com.base.dto.seminar.adminCreateSeminar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeminarImageDto {

    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("file_path")
    private String filePath;
}
