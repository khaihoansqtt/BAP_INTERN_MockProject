package com.base.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public abstract class BaseEntity<TID> implements Serializable {
    /**
     * The Create by user.
     */
    @CreatedBy
    @Column(name = "created_by_user")
    protected String createByUser;

    /**
     * The Create at time.
     */
    @CreatedDate
    @Column(name = "created_at")
    protected Date createAtTime;

    /**
     * The Update by user.
     */
    @LastModifiedBy
    @Column(name = "modified_by_user")
    protected String updateByUser;

    /**
     * The Update at time.
     */
    @LastModifiedDate
    @Column(name = "modified_at")
    protected Date updateAtTime;

    /**
     * The Is deleted.
     */
    @Column(name = "is_deleted")
    protected Boolean isDeleted = false;

    /**
     *
     * @return
     */
    public abstract TID getId();
}
