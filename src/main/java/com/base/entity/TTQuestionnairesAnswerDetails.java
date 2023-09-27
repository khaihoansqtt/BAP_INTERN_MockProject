package com.base.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TT_QUESTIONNAIRES_ANSWER_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TTQuestionnairesAnswerDetails extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTIONNAIRE_ANSWER_DETAILS_ID")
    private int questionnaireAnswerDetailsId;

    @Column(name = "DISPLAY_CATEGORY")
    private short displayCategory;

    @Column(name = "MEDICALCATEGORY_ID")
    private int medicalCategoryId;

    @Column(name = "QUESTION")
    private String question;

    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "QUESTIONNAIRE_ANSWER_ID")
    private TTQuestionnairesAnswer ttQuestionnairesAnswer;
}
