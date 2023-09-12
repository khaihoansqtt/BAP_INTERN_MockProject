package com.base.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO implements Serializable {
    protected String createByUser;
    protected String createAtTime;
    protected String updateByUser;
    protected String updateAtTime;
    protected Boolean isDeleted = false;
}
