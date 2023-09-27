package com.base.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TH_QUESTIONNAIRES_CHOICES_HISTORY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TTQuestionnairesChoicesHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTIONNAIRES_CHOICES_HISTORY_ID")
    private int questionnairesChoicesHistoryId;

    @Column(name = "QUESTIONNAIRE_CHOICE_ID")
    private int questionnaireChoiceId;

    @Column(name = "QUESTION_TEXT")
    private String questionText;

    @Column(name = "EXCLUSION_KEY")
    private int exclusionKey;

    @Column(name = "IS_DELETE")
    private boolean isDelete;
}
