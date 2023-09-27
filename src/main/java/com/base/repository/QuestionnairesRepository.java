package com.base.repository;

import com.base.entity.TTQuestionnaires;
import com.base.entity.TTSeminarDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnairesRepository extends JpaRepository<TTQuestionnaires, Integer> {
}
