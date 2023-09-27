package com.base.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TH_QUESTIONNAIRES_QUESTION_HISTORY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TTQuestionnairesQuestionHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTIONNAIRE_QUESTION_HISTORY_ID")
    private int questionnaireQuestionHistoryId;

    @Column(name = "QUESTIONNAIRE_QUESTION_ID")
    private int questionnaireQuestionId;

    @Column(name = "QUESTION")
    private String question;

    @Column(name = "EXCLUSION_KEY")
    private int exclusionKey;

    @Column(name = "IS_DELETE")
    private boolean isDelete;
}
