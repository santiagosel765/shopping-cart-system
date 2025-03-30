package com.shopping.auth.repository;

import com.shopping.common.entity.user.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusRepository extends JpaRepository<UserStatus, Integer> {
}