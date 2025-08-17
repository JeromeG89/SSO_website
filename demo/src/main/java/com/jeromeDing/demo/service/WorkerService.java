package com.jeromeDing.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeromeDing.demo.entity.Worker;
import com.jeromeDing.demo.repository.WorkerRepository;

@Service
public class WorkerService {
    private final WorkerRepository repo;

    public WorkerService(WorkerRepository repo) {
        this.repo = repo;
    }

    public Worker addWorker(String name, Double hourlyRate) {
        Worker worker = new Worker(name, hourlyRate);
        return repo.save(worker);
    }

    public List<Worker> getAllWorkers() {
        return repo.findAll();
    }
}
