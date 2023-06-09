package com.example.findapro.core.task;

import com.example.findapro.domain.Category;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class TaskDto {
    private String taskName;
    private String description;
    private Integer expectedPrice;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(Integer expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

}
