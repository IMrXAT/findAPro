package com.example.findapro.domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "status")
public class Status {
    @Id @GeneratedValue
    private Long id;
    private String statusName;

    @OneToMany
    private Collection<Task> tasks;

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {

        this.tasks = tasks;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
