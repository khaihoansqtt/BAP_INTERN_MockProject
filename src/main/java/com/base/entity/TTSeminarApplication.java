package com.base.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TT_SEMINAR_APPLICATION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TTSeminarApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEMINAR_APPLICATION_ID")
    private int seminarApplicationId;

    // quan he
    @Column(name = "MEMBER_ID")
    private int memberId;

    // co the
    @Column(name = "SEMINAR_APPLICATION_CATEGORY")
    private int seminarApplicationCategory;

    // quan he
    @Column(name = "QUESTIONNAIRE_ANSWER_ID")
    private int questionnaireAnswerId;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "SEMINAR_ID")
    private TTSeminar ttSeminar;
}
