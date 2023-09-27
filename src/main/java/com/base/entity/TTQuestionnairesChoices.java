package com.base.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TT_QUESTIONNAIRES_CHOICES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TTQuestionnairesChoices extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTIONNAIRE_CHOICE_ID")
    private int questionnaireChoiceId;

    @Column(name = "QUESTION_TEXT")
    private String questionText;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="QUESTIONNAIRE_QUESTION_ID")
    private TTQuestionnairesQuestion ttQuestionnairesQuestion;
}
