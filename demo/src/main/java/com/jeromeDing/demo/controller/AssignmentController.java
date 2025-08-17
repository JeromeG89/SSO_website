package com.jeromeDing.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeromeDing.demo.entity.Worker;
import com.jeromeDing.demo.service.WorkerService;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {
    private final WorkerService workerService;
    private final AssignmentService assignmentService;

    public AssignmentController(WorkerService service) {
        this.service = service;
    }

    @PostMapping
    public Worker addWorker(@RequestParam String name, @RequestParam Double hourlyRate) {
        return service.addWorker(name, hourlyRate);
    }

    @GetMapping
    public List<Worker> getWorkers() {
        return service.getAllWorkers();
    }

    
}
