package com.base.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TT_QUESTIONNAIRES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TTQuestionnaires extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTIONNAIRE_ID")
    private int questionnaireId;

    @Column(name = "DISPLAY_CATEGORY")
    private short displayCategory;

    @Column(name = "MEDICAL_CATEGORY_ID")
    private int  medicalCategoryId;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @OneToMany(mappedBy = "ttQuestionnaires", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<TTQuestionnairesQuestion> ttQuestionnairesQuestions;

    @OneToOne(mappedBy = "ttQuestionnaires", cascade = {CascadeType.ALL})
    private TTSeminar ttSeminar;
}
