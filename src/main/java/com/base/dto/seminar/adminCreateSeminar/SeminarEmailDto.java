package com.base.dto.seminar.adminCreateSeminar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeminarEmailDto {

    @JsonProperty("optional_message_hall")
    private String optionalMessageHall;

    @JsonProperty("optional_message_online")
    private String optionalMessageOnline;
}