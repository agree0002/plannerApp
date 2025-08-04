package com.igrus.api.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 사용자명 존재 여부 확인
     */
    boolean existsByUsername(String username);
}