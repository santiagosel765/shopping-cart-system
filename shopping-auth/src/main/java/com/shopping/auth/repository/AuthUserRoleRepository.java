package com.shopping.auth.repository;

import com.shopping.common.entity.user.AuthUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRoleRepository extends JpaRepository<AuthUserRole, Integer> {

    Optional<AuthUserRole> findByUserId(Long userId);
}
