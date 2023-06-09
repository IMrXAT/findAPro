package com.example.findapro.domain;

import com.example.findapro.domain.users.CustomerProfile;
import com.example.findapro.domain.users.ExecutorProfile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "finished_tasks")
public class FinishedTask extends Task {
    @ManyToOne
    private ExecutorProfile executor;

    private LocalDateTime closingTime;
    @Column(name = "finish_cost")
    private Integer cost;
    @Column(name = "execution_rating")
    private Double rating;

    public FinishedTask(String taskName, String description, Integer expectedPrice, LocalDateTime postTime, LocalDateTime deadline, Category category, CustomerProfile customer, TaskStatus status, ExecutorProfile executor, LocalDateTime closingTime, Integer cost, Double rating) {
        super(taskName, description, expectedPrice, postTime, deadline, category, customer, status);
        this.executor = executor;
        this.closingTime = closingTime;
        this.cost = cost;
        this.rating = rating;
    }

    public FinishedTask() {

    }

    public ExecutorProfile getExecutor() {
        return executor;
    }

    public void setExecutor(ExecutorProfile executor) {
        this.executor = executor;
    }

    public LocalDateTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalDateTime closingTime) {
        this.closingTime = closingTime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
