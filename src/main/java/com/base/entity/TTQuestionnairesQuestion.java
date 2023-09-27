package com.base.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TT_QUESTIONNAIRES_QUESTION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TTQuestionnairesQuestion extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTIONNAIRE_QUESTION_ID")
    private int questionnaireQuestionId;

    @Column(name = "IS_REQUIRED_ANSWER")
    private boolean isRequiredAnswer;

    @Column(name = "QUESTIONNAIRE_CDFORMAT")
    private int questionnaireCdformat;

    @Column(name = "QUESTIONNAIRE_QUESTION")
    private String questionnaireQuestion;

    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "DISPLAY_ORDER")
    private int displayOrder;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="QUESTIONNAIRE_ID")
    private TTQuestionnaires ttQuestionnaires;

    @OneToMany(mappedBy = "ttQuestionnairesQuestion", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<TTQuestionnairesChoices> ttQuestionnairesChoicesList;
}
