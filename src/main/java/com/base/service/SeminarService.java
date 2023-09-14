package com.base.service;

import com.base.dto.BaseResDto;
import com.base.dto.seminar.getSeminars.GetSeminarsResDto;

public interface SeminarService {
    BaseResDto<GetSeminarsResDto> getSeminars();
}
