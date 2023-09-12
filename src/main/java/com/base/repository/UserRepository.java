package com.base.repository;

import com.base.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    /**
     * find User by email
     * @param email
     * @return
     */
    Optional<User> findByEmailAndIsDeletedIsFalse(String email);

    /**
     * find User by userName
     * @param userName
     * @return
     */
    Optional<User> findByUserNameAndIsDeletedIsFalse(String userName);

    /**
     * Save and flush user entity.
     *
     * @param entity the entity
     * @return the user entity
     */
    User saveAndFlush(User entity);
}
