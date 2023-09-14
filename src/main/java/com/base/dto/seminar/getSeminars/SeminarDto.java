package com.base.dto.seminar.getSeminars;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SeminarDto {
    @JsonProperty("seminar_title")
    private String serminarTittle;

    @JsonProperty("is_hall_seminar")
    private boolean isHallSeminar;

    @JsonProperty("is_online_seminar")
    private boolean isOnlineSeminar;

    @JsonProperty("seminar_id")
    private int seminarId;

    @JsonProperty("list_overview")
    private String listOverview;

    @JsonProperty("event_startdate")
    private Date eventStartdate;

    @JsonProperty("event_enddate")
    private Date eventEndDate;

    @JsonProperty("publication_start_date_time")
    private Date publicationStartDateTime;

    @JsonProperty("publication_end_date_time")
    private Date publicationEndDateTime;

    @JsonProperty("seminar_application_category")
    private String seminarApplicationCategory;
}
