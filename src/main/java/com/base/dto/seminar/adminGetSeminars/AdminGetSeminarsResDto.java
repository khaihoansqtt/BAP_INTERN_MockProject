package com.base.dto.seminar.adminGetSeminars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AdminGetSeminarsResDto {
    List<SeminarDto> seminars;
}
