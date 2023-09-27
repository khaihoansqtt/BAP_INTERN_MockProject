package com.base.dto.seminar.adminCreateSeminar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminCreateSeminarReqAndResDto {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @JsonProperty("event_startdate")
    private Date eventStartdate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @JsonProperty("event_enddate")
    private Date eventEnddate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @JsonProperty("publication_start_date_time")
    private Date publicationStartDateTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
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

    @JsonProperty("seminar_attribute")
    private List<SeminarAttributeDto> seminarAttributeDtoList;

    @JsonProperty("seminar_images")
    private List<SeminarImageDto> seminarImageDtoList;

    @JsonProperty("seminar_details")
    private SeminarDetailsDto seminarDetailsDto;

    @JsonProperty("seminar_emails")
    private SeminarEmailDto seminarEmailDto;

    @JsonProperty("seminar_questions")
    private List<SeminarQuestionDto> seminarQuestionDtoList;
}
