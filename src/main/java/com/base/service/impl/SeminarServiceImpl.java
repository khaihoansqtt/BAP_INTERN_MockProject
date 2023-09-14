//package com.base.service.impl;
//
//import com.base.dto.BaseOkResDto;
//import com.base.dto.seminar.getSeminars.getSeminarsResDto;
//import com.base.entity.TTSeminar;
//import com.base.repository.SeminarRepository;
//import com.base.service.SeminarService;
//import com.base.spring.exception.NoSeminarExisted;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Optional;
//
//public class SeminarServiceImpl implements SeminarService {
//    @Autowired
//    SeminarRepository seminarRepository;
//    @Override
//    public BaseOkResDto<getSeminarsResDto> getSeminars() {
//        Optional<List<TTSeminar>> seminarListOptional = seminarRepository.findAllByIsDeletedIsFalse();
//        if (seminarListOptional.isPresent()) {
//            List<TTSeminar> seminarList = seminarListOptional.get();
//
//        } else throw new NoSeminarExisted();
//    }
//}
