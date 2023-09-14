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
@Table(name = "TM_OCCUPATIONS")
public class TMOccupations extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OCCUPATION_ID")
	private Integer occupationId;

	@Column(name = "OCCUPATION_NAME", nullable = false)
	private String medicalCategoryName;

	@Column(name = "IS_DELETE", nullable = false)
	private Boolean isDelete;
	
	@OneToMany(mappedBy = "tmOccupations")
    private Set<TTMember> ttMembers = new HashSet<>();
}
