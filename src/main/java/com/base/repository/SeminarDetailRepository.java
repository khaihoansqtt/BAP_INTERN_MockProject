package com.base.repository;

import com.base.entity.TTSeminarDetail;
import com.base.entity.TTSeminarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeminarDetailRepository extends JpaRepository<TTSeminarDetail, Integer> {
}
