package com.example.findapro.domain.users;

import com.example.findapro.domain.FinishedTask;
import com.example.findapro.domain.Task;
import com.example.findapro.domain.users.User;
import jakarta.persistence.*;

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
    @ManyToMany
    @JoinTable(
            name = "tasks_responses",
            joinColumns = @JoinColumn(name = "executor_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> responseTasks;



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
