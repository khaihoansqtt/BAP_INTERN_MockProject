package com.base.dto.seminar.getSeminars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetSeminarsResDto {
    List<SeminarDto> seminars;
}
