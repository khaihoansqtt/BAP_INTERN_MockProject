package com.base.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto implements Serializable {

    protected String createFuncId;
    protected int createPersonId;
    protected Date createDateTime;

    protected String updateFuncId;

    protected int updatePersonId;

    protected Date updateDateTime;
}
