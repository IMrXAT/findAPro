package com.example.findapro.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "executors")
public class ExecutorProfile extends User {

    @Column(name = "rating")
    private Double rating;
    @Column(name = "description")
    private String description;
    @OneToMany
    private List<FinishedTask> finishedTasks;


    //getters and setters

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FinishedTask> getFinishedTasks() {
        return finishedTasks;
    }

    public void setFinishedTasks(List<FinishedTask> finishedTasks) {
        this.finishedTasks = finishedTasks;
    }
}
