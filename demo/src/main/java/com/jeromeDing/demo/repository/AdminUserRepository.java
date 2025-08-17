package com.jeromeDing.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeromeDing.demo.entity.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {}
