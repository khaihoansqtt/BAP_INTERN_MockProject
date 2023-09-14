package com.base.entity;

import java.sql.Date;
import java.util.List;

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
@Table(name = "TT_MEMBER")
@IdClass(TTMemberId.class)
public class TTMember extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private Integer memberId;

	@Id
	@Column(name = "MEMBER_MAIL_ADDRESS", nullable = false)
	private String memberMailAddress;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "MEMBER_STATUS", nullable = false)
	private Short memberStatus;

	@Column(name = "REGISTER_DATE_TIME", columnDefinition = "DATETIME")
	private Date registerDateTime;

	@Column(name = "MEDICALINSTITUTION_NAME", nullable = false)
	private String medicalInstitutionName;

	@Column(name = "MEDICALINSTITUTION_NAME_KANA", nullable = false)
	private String medicalInstitutionNameKana;

	@Column(name = "MEMBER_LAST_NAME", nullable = false)
	private String memberLastName;

	@Column(name = "MEMBER_FIRST_NAME", nullable = false)
	private String memberFirstName;

	@Column(name = "MEMBER_LAST_NAME_KANA", nullable = false)
	private String memberLastNameKana;

	@Column(name = "MEMBER_FIRST_NAME_KANA", nullable = false)
	private String memberFirstNameKana;

	@Column(name = "POSTAL_CD", nullable = false)
	private String postalCd;

//	PREFECTURE_ID int(10) unsigned NOT NULL COMMENT '都道府県',
	@ManyToOne
	@JoinColumn(name = "PREFECTURE_ID")
	private TMPrefecture tmPrefecture;

	@Column(name = "MUNICIPALITIES", nullable = false)
	private String municipalities;

	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@Column(name = "BUILDING")
	private String building;

	@Column(name = "TELEPHONE", nullable = false)
	private String telephone;

	@Column(name = "FAX_NUMBER", nullable = false)
	private String faxNumber;

//	MEDICALCATEGORY_ID int(10) unsigned NOT NULL COMMENT '医療区分',
	@ManyToOne
	@JoinColumn(name = "MEDICALCATEGORY_ID")
	private TMMedicalCategory tmMedicalCategory;

// SECRET_QUESTION_ID int(10) unsigned COMMENT '秘密の質問',
	@ManyToOne
	@JoinColumn(name = "SECRET_QUESTION_ID")
	private TMSecretQuestions tmSecretQuestions;

	@Column(name = "ANSWER_QUESTION")
	private String answerQuestion;

	@Column(name = "DEPARTMENT")
	private String department;

//	OCCUPATION_ID int(10) unsigned COMMENT '職種',
	@ManyToOne
	@JoinColumn(name = "OCCUPATION_ID")
	private TMOccupations tmOccupations;
	
//	SERVICE_CATEGORY_ID int(10) unsigned COMMENT '勤務区分',
	@ManyToOne
	@JoinColumn(name = "SERVICE_CATEGORY_ID")
	private TMServiceCategories tmServiceCategories;
	
	//	OFFICER_ID int(10) unsigned COMMENT '役職',
	@ManyToOne
	@JoinColumn(name = "OFFICER_ID")
	private TMOfficers tmOfficers;

	@Column(name = "IS_DELETE", nullable = false)
	private Boolean isDelete;

	@Column(name = "IS_DELIVERY", nullable = false)
	private Boolean isDelivery;

//	PROXY_INPUT_USER_ID int(10) unsigned COMMENT '代行入力ユーザー',
	@ManyToOne
	@JoinColumn(name = "PROXY_INPUT_USER_ID")
	private TTEmployee proxyInputUser;
	
	@Column(name = "IS_FIRST_LOGIN", nullable = false)
	private Boolean isFirstLogin;

	@Column(name = "LOCK_TIME",  columnDefinition="DATETIME")
	private Date lockTime;

	@Column(name = "NEW_EMAIL_ADDRESS")
	private String newEmailAddress;

	@Column(name = "AUTH_NUMBER")
	private String authMember;

	@Column(name = "AUTH_NUMBER_LIMIT",  columnDefinition="DATETIME")
	private Date authNumberLimit;

	@Column(name = "WITHDRAWAL_REASON")
	private String withdrawalReason;

	@Column(name = "OTHER_OPINION")
	private String otherOpinion;

	@OneToMany(mappedBy = "ttMember")
	private List<TTToken> ttTokens;
}
