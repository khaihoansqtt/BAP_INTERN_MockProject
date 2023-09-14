package com.base.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode
public class TTMemberId implements Serializable {
    private Integer memberId;
    private String memberMailAddress;
}
