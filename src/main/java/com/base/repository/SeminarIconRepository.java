package com.base.repository;

import com.base.entity.TMIcon;
import com.base.entity.TRSeminarIcon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeminarIconRepository extends JpaRepository<TRSeminarIcon, Integer> {
}
