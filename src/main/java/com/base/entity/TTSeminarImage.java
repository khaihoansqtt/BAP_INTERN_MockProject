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
@Table(name = "TT_SEMINAR_IMAGE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TTSeminarImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEMINAR_IMAGE_ID")
    private int seminarImageId;

    // co the co quan he
    @Column(name = "IMAGE_CATEGORY")
    private int imageCategory;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_PATH")
    private String filePath;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @OneToOne(mappedBy = "ttSeminarImage", cascade = {CascadeType.ALL})
    private TTSeminarDetail ttSeminarDetail;

    @OneToOne( cascade = {CascadeType.ALL})
    @JoinColumn(name = "SEMINAR_ID")
    private TTSeminar ttSeminar;
}
