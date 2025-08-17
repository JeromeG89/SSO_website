package com.jeromeDing.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jeromeDing.demo.entity.WorkAssignment;
import com.jeromeDing.demo.repository.AssignmentRepoistory;

@Service
public class AssignmentService {
    private final AssignmentRepoistory assignmentRepoistory;

    public AssignmentService(AssignmentRepoistory assignmentRepoistory) {
        this.assignmentRepoistory = assignmentRepoistory;
    }

    public WorkAssignment addAssignment(Date start, Date end) {
        WorkAssignment assignment = new WorkAssignment(start, end);
        return this.assignmentRepoistory.save(assignment);
    }

    public List<WorkAssignment> getAllAssignments() {
        return this.assignmentRepoistory.findAll();
    }

    public WorkAssignment removeAssignment(Long id) {
        return assignmentRepoistory.findById(id)
            .map(assignment -> {
                assignmentRepoistory.delete(assignment);
                return assignment;
            })
            .orElseThrow(() -> new RuntimeException("Assignment not found with id: " + id));
    }
}
