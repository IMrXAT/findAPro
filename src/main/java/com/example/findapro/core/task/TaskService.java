package com.example.findapro.core.task;

import com.example.findapro.core.user.UserRepository;
import com.example.findapro.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public void delete(Long taskId) {
        taskRepository.findById(taskId)
                .map(task -> {
                    taskRepository.delete(task);
                    return true;
                }).orElseThrow(() -> new RuntimeException("No task at " + taskId));
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

//    public void createTask(NewTask newTask, String login) {
//        taskRepository.saveAndFlush(new Task(
//                newTask.taskName(),
//                newTask.description(),
//                newTask.expectedPrice(),
//                LocalDateTime.now(),
//                LocalDateTime.of(2023, Month.DECEMBER, 31, 1, 1),
//                newTask.category(),
//                userRepository.findByLogin(login),
//                TaskStatus.OPEN)
//        );
//    }
}
