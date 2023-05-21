package com.example.findapro.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "finished_tasks")
public class FinishedTask extends Task {
    @ManyToOne
    private ExecutorProfile executor;

    private LocalDateTime closingTime;
    private String cost;
    private Double rating;

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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
