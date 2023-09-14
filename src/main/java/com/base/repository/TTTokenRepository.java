package com.base.repository;

import com.base.entity.TTToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TTTokenRepository extends JpaRepository<TTToken, Integer> {
    Optional<TTToken> findByToken(String token);
}
