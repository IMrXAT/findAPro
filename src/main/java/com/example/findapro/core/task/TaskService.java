package com.example.findapro.core.task;


import com.example.findapro.domain.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }


    public List<Task> getTasks() {
        return repository.findAll();
    }
}
