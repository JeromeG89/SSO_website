package com.jeromeDing.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeromeDing.demo.entity.WorkAssignment;
import com.jeromeDing.demo.service.AssignmentService;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {
    // private final WorkerService workerService;
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public WorkAssignment addAssignment(@RequestParam Date start, @RequestParam Date end) {
        return assignmentService.addAssignment(start, end);
    }

    @GetMapping
    public List<WorkAssignment> getWorkers() {
        return assignmentService.getAllAssignments();
    }

    
}
