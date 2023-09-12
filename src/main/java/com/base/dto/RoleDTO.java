package com.base.dto;

import lombok.*;

@Getter
@Setter
public class RoleDTO extends BaseDTO{
    private Long id;
    private String name;
    private String description;
}
