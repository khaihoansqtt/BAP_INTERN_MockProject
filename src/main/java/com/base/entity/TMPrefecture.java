package com.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TM_PREFECTURE")
public class TMPrefecture extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PREFECTURE_ID")
	private Integer prefectureId;

	@Column(name = "PREFECTURE_NAME", nullable = false)
	private String prefectureName;

	@Column(name = "IS_DELETE", nullable = false)
	private Boolean isDelete;
	
	@OneToMany(mappedBy = "tmPrefecture")
    private Set<TTMember> ttMembers = new HashSet<>();
}
