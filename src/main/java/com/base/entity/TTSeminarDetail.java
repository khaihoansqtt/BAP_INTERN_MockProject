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
@Table(name = "TT_SEMINAR_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TTSeminarDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEMINAR_DETAIL_ID")
    private int seminarDetailId;

    @Column(name = "DISPLAY_ORDER")
    private int displayOrder;

    @Column(name = "HEADLINE")
    private String headline;

    @Column(name = "CONTENTS")
    private String contents;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @Column(name = "CREATE_FUNC_ID")
    private String createFuncId;

    @Column(name = "CREATE_PERSON_ID")
    private int createPersonId;

    @Column(name = "CREATE_DATE_TIME")
    private Date createDateTime;

    @Column(name = "UPDATE_FUNC_ID")
    private String updateFuncId;

    @Column(name = "UPDATE_PERSON_ID")
    private int updatePersonId;

    @Column(name = "UPDATE_DATE_TIME")
    private Date updateDateTime;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "SEMINAR_ID")
    private TTSeminar ttSeminar;
}
