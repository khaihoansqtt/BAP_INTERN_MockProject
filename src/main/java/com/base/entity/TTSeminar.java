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
@Table(name = "TT_SEMINAR")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TTSeminar extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEMINAR_ID")
    private int seminarId;

    @Column(name = "SEMINAR_TITLE")
    private String seminarTitle;

    @Column(name = "IS_HALL_SEMINAR")
    private boolean isHallSeminar;

    @Column(name = "IS_ONLINE_SEMINAR")
    private boolean isOnlineSeminar;

    @Column(name = "EVENT_STARTDATE")
    private Date eventStartdate;

    @Column(name = "EVENT_ENDDATE")
    private Date eventEndDate;

    @Column(name = "PUBLICATION_START_DATE_TIME")
    private Date publicationStartDateTime;

    @Column(name = "PUBLICATION_END_DATE_TIME")
    private Date publicationEndDateTime;

    @Column(name = "LIST_OVERVIEW")
    private String listOverview;

    @Column(name = "SEMINAR_MAXIMUM_PARTICIPANT")
    private int seminarMaximumParticipant;

    @Column(name = "ONLINE_VIEW_URL")
    private String onlineViewUrl;

    //		cos quan he
    @Column(name = "QUESTIONNAIRE_ID")
    private int questionnaireId;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @OneToOne(mappedBy = "ttSeminar", cascade = {CascadeType.ALL})
    private TTSeminarDetail ttSeminarDetail;

    @OneToOne(mappedBy = "ttSeminar", cascade = {CascadeType.ALL})
    private TTSeminarImage ttSeminarImage;

    @OneToMany(mappedBy = "ttSeminar", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private TTSeminarApplication ttSeminarApplication;

    @OneToOne(mappedBy = "ttSeminar", cascade = {CascadeType.ALL})
    private TRSeminarIcon trSeminarIcon;
}
