package com.jeromeDing.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class Worker extends User {

    private Double hourlyRate;

    protected Worker() {} // JPA

    public Worker(String name, Double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }

    public Worker(String name) {
        this(name, 12.0); // default rate
    }

    // Getters/Setters
    public Double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(Double hourlyRate) { this.hourlyRate = hourlyRate; }
}
