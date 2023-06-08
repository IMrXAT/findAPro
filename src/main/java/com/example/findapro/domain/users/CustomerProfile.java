package com.example.findapro.domain.users;

import com.example.findapro.domain.Task;
import com.example.findapro.domain.users.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerProfile extends User {

    @Column(name = "rating")
    private Double rating;

    @OneToMany
    private List<Task> tasks;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
