package com.base.repository;

import com.base.entity.Role;

import java.util.List;

public interface RoleRepository extends BaseRepository<Role, Long> {
    /**
     * Find By IsDeleted Is False And Name In roleNames
     * @param roleNames
     * @return
     */
    List<Role> findByIsDeletedIsFalseAndNameIn(List<String> roleNames);
}
