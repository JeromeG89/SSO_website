package com.jeromeDing.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeromeDing.demo.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    public Worker findByName(String Name);
    public Worker findById(int workerId);
}