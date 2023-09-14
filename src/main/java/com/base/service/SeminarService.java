package com.base.service;

import com.base.dto.BaseOkResDto;
import com.base.dto.BaseResDto;
import com.base.dto.seminar.getSeminars.getSeminarsResDto;

public interface SeminarService {
    BaseOkResDto<getSeminarsResDto> getSeminars();
}
