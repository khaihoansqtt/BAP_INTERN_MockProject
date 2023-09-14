package com.base.repository;

import com.base.entity.TTSeminar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeminarRepository extends JpaRepository<TTSeminar, Integer> {
    Optional<TTSeminar> findAllByIsDeleteFalse();
}
