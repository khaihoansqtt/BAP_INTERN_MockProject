package com.base.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * BaseEntity
 * @param <TID> the type parameter
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
public abstract class BaseEntity implements Serializable {

    @Column(name = "CREATE_FUNC_ID")
    private String createFuncId;

    @Column(name = "CREATE_PERSON_ID")
    private int createPersonId;

    @Column(name = "CREATE_DATE_TIME")
    private Date createDateTime;

    @Column(name = "UPDATE_FUNC_ID")
    private String updateFuncId;

    @Column(name = "UPDATE_PERSON_ID")
    private int updatePersonId;

    @Column(name = "UPDATE_DATE_TIME")
    private Date updateDateTime;
}
