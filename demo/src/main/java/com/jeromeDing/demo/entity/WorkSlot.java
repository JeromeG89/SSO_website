package com.jeromeDing.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "work_slots")
public class WorkSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // each slot belongs to one assignment
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id")
    private WorkAssignment assignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    protected WorkSlot() {}

    public WorkSlot(Worker worker, Date start, Date end) {
        this.worker = worker;
        this.start = start;
        this.end = end;
    }

    void setAssignment(WorkAssignment assignment) {
        this.assignment = assignment;
    }

    // getters
    public Long getId() { return id; }
    public Worker getWorker() { return worker; }
    public Date getStart() { return start; }
    public Date getEnd() { return end; }
}
