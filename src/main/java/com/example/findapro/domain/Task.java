package com.example.findapro.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

enum TaskStatus{
    IN_PROGRESS,
    FINISHED,
    NOT_STARTED
}

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime post_time;
    private String description;
    private String taskName;
    private LocalDateTime deadline;
    private Integer expectedPrice;

    @ManyToOne
    private CustomerProfile customer;

    @ManyToOne(optional = false)
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPost_time() {
        return post_time;
    }

    public void setPost_time(LocalDateTime post_time) {
        this.post_time = post_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Integer getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(Integer expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public CustomerProfile getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}