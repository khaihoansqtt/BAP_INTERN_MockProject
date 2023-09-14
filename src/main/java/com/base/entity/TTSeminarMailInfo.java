package com.base.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TT_SEMINAR_MAIL_INFO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TTSeminarMailInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEMINAR_MAIL_INFO_ID")
    private int seminarMailInfoId;

    @Column(name = "MAIL_CATEGORY")
    private boolean mailCategory;

    @Column(name = "OPTIONAL_MESSAGE_HALL")
    private boolean optionalMessageHall;

    @Column(name = "OPTIONAL_MESSAGE_ONLINE")
    private Date optionalMessageOnline;

    @Column(name = "IS_DELETE")
    private Date isDelete;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "SEMINAR_ID")
    private TTSeminar ttSeminar;
}
