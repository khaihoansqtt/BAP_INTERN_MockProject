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
@Table(name = "TM_SERVICE_CATEGORIES")
public class TMServiceCategories extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SERVICE_CATEGORY_ID")
	private Integer serviceCategoryId;

	@Column(name = "SERVICE_CATEGORY_NAME", nullable = false)
	private String serviceCategoryName;

	@Column(name = "IS_DELETE", nullable = false)
	private Boolean isDelete;
	
	@OneToMany(mappedBy = "tmServiceCategories")
    private Set<TTMember> ttMembers = new HashSet<>();
}
