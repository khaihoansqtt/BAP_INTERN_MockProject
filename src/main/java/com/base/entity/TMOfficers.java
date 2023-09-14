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
@Table(name = "TM_OFFICERS")
public class TMOfficers extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OFFICER_ID")
	private Integer officerId;

	@Column(name = "OFFICER_NAME", nullable = false)
	private String officerName;

	@Column(name = "IS_DELETE", nullable = false)
	private Boolean isDelete;
	
	@OneToMany(mappedBy = "tmOfficers")
    private Set<TTMember> ttMembers = new HashSet<>();
}
