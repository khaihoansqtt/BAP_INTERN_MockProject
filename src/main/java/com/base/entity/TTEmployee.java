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
@Table(name = "TT_EMPLOYEES")
public class TTEmployee extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;

	@Column(name = "EMPLOYEE_MAIL_ADDRESS", nullable = false)
	private String employeeMailAddress;

	@Column(name = "EMPLOYEE_PASSWORD", nullable = false)
	private String employeePassword;
	
	@Column(name = "EMPLOYEE_NAME", nullable = false)
	private String employeeName;
	
	@Column(name = "IS_DELETE", nullable = false)
	private Boolean isDelete;
	
	@Column(name = "IS_FIRST_LOGIN", nullable = false)
	private Boolean isFirstLogin;
	
	@OneToMany(mappedBy = "proxyInputUser")
    private Set<TTMember> ttMembers = new HashSet<>();
}
