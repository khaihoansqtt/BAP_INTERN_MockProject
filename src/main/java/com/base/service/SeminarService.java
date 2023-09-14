
package com.base.service;

import com.base.dto.BaseResDto;
import com.base.dto.seminar.getSeminars.GetSeminarsResDto;
import org.springframework.stereotype.Service;

@Service
public interface SeminarService {
    BaseResDto<GetSeminarsResDto> getSeminars();
}
