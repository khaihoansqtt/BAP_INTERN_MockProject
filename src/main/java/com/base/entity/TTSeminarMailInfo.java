package com.base.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TT_SEMINAR_MAIL_INFO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TTSeminarMailInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEMINAR_MAIL_INFO_ID")
    private int seminarMailInfoId;

    @Column(name = "MAIL_CATEGORY")
    private int mailCategory;

    @Column(name = "OPTIONAL_MESSAGE_HALL")
    private String optionalMessageHall;

    @Column(name = "OPTIONAL_MESSAGE_ONLINE")
    private String optionalMessageOnline;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "SEMINAR_ID")
    private TTSeminar ttSeminar;
}
