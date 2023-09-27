package com.base.repository;

import com.base.entity.TMIcon;
import com.base.entity.TTSeminarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeminarImageRepository extends JpaRepository<TTSeminarImage, Integer> {
}
