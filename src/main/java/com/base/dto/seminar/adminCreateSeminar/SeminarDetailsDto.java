package com.base.dto.seminar.adminCreateSeminar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeminarDetailsDto {

    @JsonProperty("headline")
    private String headline;

    @JsonProperty("contents")
    private String content;
}