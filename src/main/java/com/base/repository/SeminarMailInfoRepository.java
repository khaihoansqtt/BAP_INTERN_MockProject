package com.base.repository;

import com.base.entity.TTSeminarImage;
import com.base.entity.TTSeminarMailInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeminarMailInfoRepository extends JpaRepository<TTSeminarMailInfo, Integer> {
}
