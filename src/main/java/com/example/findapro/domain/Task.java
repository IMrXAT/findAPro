package com.example.findapro.domain;

import com.example.findapro.domain.users.CustomerProfile;
import com.example.findapro.domain.users.ExecutorProfile;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tasks")
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String taskName;
    private String description;
    private Integer expectedPrice;
    private LocalDateTime postTime;
    private LocalDateTime deadline;
    @ManyToOne
    private Category category;
    @ManyToOne
    private CustomerProfile customer;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToMany(mappedBy = "responseTasks")
    private List<ExecutorProfile> executorsSentResponse;


    public List<ExecutorProfile> getExecutorsSentResponse() {
        return executorsSentResponse;
    }

    public void setExecutorsSentResponse(List<ExecutorProfile> executorsSentResponse) {
        this.executorsSentResponse = executorsSentResponse;
    }

    public Task(String taskName, String description, Integer expectedPrice, LocalDateTime postTime, LocalDateTime deadline, Category category, CustomerProfile customer, TaskStatus status) {
        this.taskName = taskName;
        this.description = description;
        this.expectedPrice = expectedPrice;
        this.postTime = postTime;
        this.deadline = deadline;
        this.category = category;
        this.customer = customer;
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime post_time) {
        this.postTime = post_time;
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