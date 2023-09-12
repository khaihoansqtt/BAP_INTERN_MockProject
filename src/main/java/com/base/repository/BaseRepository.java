package com.base.repository;

import com.base.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<ENTITY extends BaseEntity, ID> extends JpaRepository<ENTITY, ID> {
    /**
     * find undeleted entity by Id
     */
    Optional<ENTITY> findByIdAndIsDeletedIsFalse(ID id);

    /**
     * find all data undeleted
     */
    Optional<List<ENTITY>> findAllByIsDeletedIsFalse();
}
