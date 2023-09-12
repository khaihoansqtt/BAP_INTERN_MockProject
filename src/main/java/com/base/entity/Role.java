package com.base.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends BaseEntity<Long> {

    @Id
    @Column
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column
    private String description;
}
