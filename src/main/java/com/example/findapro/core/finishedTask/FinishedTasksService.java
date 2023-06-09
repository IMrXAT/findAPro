package com.example.findapro.core.finishedTask;

import com.example.findapro.domain.FinishedTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinishedTasksService {

    private final FinishedTaskRepository finishedTaskRepository;

    public FinishedTasksService(FinishedTaskRepository finishedTaskRepository) {
        this.finishedTaskRepository = finishedTaskRepository;
    }

    public List<FinishedTask> getFinishedTasks() {
        return finishedTaskRepository.findAll();
    }
}
