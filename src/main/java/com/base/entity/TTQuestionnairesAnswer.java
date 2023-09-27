package com.base.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TT_QUESTIONNAIRES_ANSWER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TTQuestionnairesAnswer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTIONNAIRE_ANSWER_ID")
    private int questionnaireQuestionId;

    @Column(name = "QUESTIONNAIRE_ID")
    private int questionnaireId;

    @Column(name = "MEMBER_ID")
    private int memberId;

    @Column(name = "RESPON_SETTIME")
    private Date responSettime;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @OneToOne(mappedBy = "ttQuestionnairesAnswer", cascade = {CascadeType.ALL})
    private TTQuestionnairesAnswerDetails ttQuestionnairesAnswerDetails;
}
