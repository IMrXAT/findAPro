package com.example.findapro.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "tasks_responses")
public class taskResponse {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "executor_id")
    private ExecutorProfile executor;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExecutorProfile getExecutor() {
        return executor;
    }

    public void setExecutor(ExecutorProfile executor) {
        this.executor = executor;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
