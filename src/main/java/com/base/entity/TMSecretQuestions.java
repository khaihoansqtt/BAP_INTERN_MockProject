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
@Table(name = "TM_SECRET_QUESTIONS")
public class TMSecretQuestions extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SECRET_QUESTION_ID")
	private Integer secretQuestionId;

	@Column(name = "SECRET_QUESTION", nullable = false)
	private String secretQuestion;

	@Column(name = "IS_DELETE", nullable = false)
	private Boolean isDelete;

	@OneToMany(mappedBy = "tmSecretQuestions")
    private Set<TTMember> ttMembers = new HashSet<>();
}
