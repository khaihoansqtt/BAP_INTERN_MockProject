package com.base.dto.seminar.adminCreateSeminar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeminarQuestionDto {

    @JsonProperty("is_required_answer")
    private boolean isRequiredAnswer;

    @JsonProperty("questionnaire_cd_format")
    private int questionnaireCdFormat;

    @JsonProperty("questionnaire_question")
    private String questionnaireQuestion;

    @JsonProperty("answer")
    private String answer;
}
