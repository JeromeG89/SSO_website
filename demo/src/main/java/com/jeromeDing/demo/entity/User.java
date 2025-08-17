package com.jeromeDing.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, length = 100)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    protected User() {} // JPA requires no-arg constructor

    protected User(String name) {
        this.name = name;
        this.createdAt = new Date();
    }

    public Long getUserId() { return userId; }
    public String getName() { return name; }
    public Date getCreatedAt() { return createdAt; }

    public void setName(String name) { this.name = name; }
}
