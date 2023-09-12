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
@Table(name = "TR_SEMINAR_ICON")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TRSeminarIcon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEMINAR_ICON_ID")
    private int seminarIconId;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "SEMINAR_ID")
    private TTSeminar ttSeminar;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ICON_ID")
    private TMIcon tmIcon;
}
