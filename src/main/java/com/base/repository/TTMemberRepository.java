package com.base.repository;

import com.base.entity.TTMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TTMemberRepository extends JpaRepository<TTMember, Integer> {
    /**
     * find Member by email
     * @param email
     * @return
     */
    Optional<TTMember> findByMemberMailAddressAndIsDeleteIsFalse(String email);
}
