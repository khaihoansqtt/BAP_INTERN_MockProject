package com.base.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TM_ICON")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TMIcon extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ICON_ID")
    private int iconId;

    @Column(name = "ICON_NAME")
    private String iconName;

    @Column(name = "IS_DELETE")
    private boolean isDelete;

    @OneToOne(mappedBy = "tmIcon", cascade = {CascadeType.ALL})
    private TRSeminarIcon trSeminarIcon;
}
