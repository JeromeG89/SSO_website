package com.jeromeDing.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "work_assignments")
public class WorkAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    // One assignment can have many slots
    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WorkSlot> slots = new ArrayList<>();

    protected WorkAssignment() {}

    public WorkAssignment(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public void addSlot(WorkSlot slot) {
        slot.setAssignment(this);
        this.slots.add(slot);
    }

    public Long getId() { return id; }
    public Date getStart() { return start; }
    public Date getEnd() { return end; }
    public List<WorkSlot> getSlots() { return slots; }
}
