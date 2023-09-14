package com.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TM_MEDICAL_CATEGORY")
public class TMMedicalCategory extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEDICAL_CATEGORY_ID")
	private Integer medicalCategoryId;

	@Column(name = "MEDICAL_CATEGORY_NAME", nullable = false)
	private String medicalCategoryName;

	@Column(name = "IS_DELETE", nullable = false)
	private Boolean isDelete;
	
	@OneToMany(mappedBy = "tmMedicalCategory")
    private Set<TTMember> ttMembers = new HashSet<>();
}
