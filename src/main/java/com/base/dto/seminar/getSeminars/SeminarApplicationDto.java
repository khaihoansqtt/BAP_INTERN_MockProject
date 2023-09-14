package com.base.dto.seminar.getSeminars;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SeminarApplicationDto {

    @JsonProperty("seminar_application_category")
    private int seminarApplicationCategory;

    @JsonProperty("seminar_application_member")
    private int seminarApplicationMember;
}
