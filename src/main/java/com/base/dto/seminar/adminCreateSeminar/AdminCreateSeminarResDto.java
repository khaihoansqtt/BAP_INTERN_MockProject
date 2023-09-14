package com.base.dto.seminar.adminCreateSeminar;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AdminCreateSeminarResDto {

    @JsonProperty("event_startdate")
    private Date eventStartdate;

    @JsonProperty("event_enddate")
    private Date eventEndDate;

    @JsonProperty("publication_start_date_time")
    private Date publicationStartDateTime;

    @JsonProperty("publication_end_date_time")
    private Date publicationEndDateTime;

    @JsonProperty("seminar_title")
    private String serminarTittle;

    @JsonProperty("is_hall_seminar")
    private boolean isHallSeminar;

    @JsonProperty("is_online_seminar")
    private boolean isOnlineSeminar;

    @JsonProperty("seminar_maximum_participant")
    private int seminarMaximumParticipant;
}
