package com.base.entity;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TT_TOKEN")
public class TTToken extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOKEN_ID")
    private Integer memberId;

    @Column(name = "TOKEN", nullable = false)
    private String token;

    //	MEMBER_ID INT(10) UNSIGNED DEFAULT NULL,
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID"), @JoinColumn(name = "MEMBER_MAIL_ADDRESS", referencedColumnName = "MEMBER_MAIL_ADDRESS")})
    private TTMember ttMember;

//    @Column(name = "MEMBER_MAIL_ADDRESS")
//    private String memberMailAddress;

    @Column(name = "EXPIRATION_DATE_TIME_START", nullable = false, columnDefinition = "DATETIME")
    private Date expirationDateTimeStart;

    @Column(name = "EXPIRATION_DATE_TIME_END", nullable = false, columnDefinition = "DATETIME")
    private Date expirationDateTimeEnd;

}
