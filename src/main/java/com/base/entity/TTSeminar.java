package com.base.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "TT_SEMINAR")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EVENT_STARTDATE", columnDefinition = "DATETIME")
    private Date eventStartdate;

    @Column(name = "EVENT_ENDDATE")
    private Date eventEnddate;

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

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @OneToOne(mappedBy = "ttSeminar", cascade = {CascadeType.ALL})
    private TTSeminarDetail ttSeminarDetail;

    @OneToMany(mappedBy = "ttSeminar", cascade = {CascadeType.ALL})
    private List<TTSeminarImage> ttSeminarImages;

    @OneToMany(mappedBy = "ttSeminar", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<TTSeminarApplication> ttSeminarApplications;

    @OneToMany(mappedBy = "ttSeminar", cascade = {CascadeType.ALL})
    private List<TRSeminarIcon> trSeminarIcons;

    @OneToOne(mappedBy = "ttSeminar", cascade = {CascadeType.ALL})
    private TTSeminarMailInfo ttSeminarMailInfo;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "QUESTIONNAIRE_ID")
    private TTQuestionnaires ttQuestionnaires;
}
