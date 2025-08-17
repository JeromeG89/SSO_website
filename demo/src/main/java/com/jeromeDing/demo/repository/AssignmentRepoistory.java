package com.jeromeDing.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeromeDing.demo.entity.WorkAssignment;

public interface AssignmentRepoistory extends JpaRepository<WorkAssignment, Long> {
}