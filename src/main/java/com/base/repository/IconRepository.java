package com.base.repository;

import com.base.entity.TMIcon;
import com.base.entity.TTSeminar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IconRepository extends JpaRepository<TMIcon, Integer> {
}
