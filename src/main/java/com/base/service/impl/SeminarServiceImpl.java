
package com.base.service.impl;

import com.base.dto.BaseResDto;
import com.base.dto.seminar.getSeminars.GetSeminarsResDto;
import com.base.dto.seminar.getSeminars.SeminarDto;
import com.base.entity.TTSeminar;
import com.base.repository.SeminarRepository;
import com.base.service.SeminarService;
import com.base.spring.exception.NoSeminarExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
public class SeminarServiceImpl implements SeminarService {
    @Autowired
    SeminarRepository seminarRepository;
    @Override
    public BaseResDto<GetSeminarsResDto> getSeminars() {
        Optional<List<TTSeminar>> seminarListOptional = seminarRepository.findAllByIsDeleteIsFalse();

        if (seminarListOptional.isPresent()) {
            List<TTSeminar> seminars = seminarListOptional.get();

            List<SeminarDto> seminarDtos = seminars.stream().map(SeminarDto::new).collect(Collectors.toList());
            return BaseResDto.ok(new GetSeminarsResDto(seminarDtos));
        } else throw new NoSeminarExistedException();
    }
}
