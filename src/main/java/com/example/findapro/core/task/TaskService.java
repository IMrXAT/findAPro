package com.example.findapro.core.task;

import com.example.findapro.core.category.CategoryRepository;
import com.example.findapro.core.finishedTask.FinishedTaskRepository;
import com.example.findapro.core.user.UserRepository;
import com.example.findapro.core.user.executor.ExecutorRepository;
import com.example.findapro.domain.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.example.findapro.core.user.customer.CustomerRepository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final FinishedTaskRepository finishedTaskRepository;
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    private final ExecutorRepository executorRepository;

    public TaskService(TaskRepository taskRepository, FinishedTaskRepository finishedTaskRepository, CategoryRepository categoryRepository, CustomerRepository customerRepository, ExecutorRepository executorRepository) {
        this.taskRepository = taskRepository;
        this.finishedTaskRepository = finishedTaskRepository;
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.executorRepository = executorRepository;
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

    public void createTask(TaskDto newTask, String username) {
        taskRepository.saveAndFlush(new Task(
                newTask.getTaskName(),
                newTask.getDescription(),
                newTask.getExpectedPrice(),
                LocalDateTime.now(),
                LocalDateTime.of(2023, Month.DECEMBER, 31, 1, 1),
                categoryRepository.getReferenceById(6L),
                customerRepository.findByUsername(username),
                TaskStatus.OPEN
        ));
    }

    @Transactional
    public void closeTask(Long taskId, String username){
        Optional<Task> taskToFinishOpt = taskRepository.findById(taskId);
        if (taskToFinishOpt.isEmpty()){
            return;
        }
        Task taskToFinish = taskToFinishOpt.get();
        taskToFinish.setStatus(TaskStatus.FINISHED);
        taskRepository.saveAndFlush(taskToFinish);

        FinishedTask finishedTask = new FinishedTask(
                taskToFinish.getTaskName(),
                taskToFinish.getDescription(),
                taskToFinish.getExpectedPrice(),
                taskToFinish.getPostTime(),
                taskToFinish.getDeadline(),
                taskToFinish.getCategory(),
                taskToFinish.getCustomer(),
                taskToFinish.getStatus(),
                executorRepository.findById(3L).get(),
                LocalDateTime.now(),
                taskToFinish.getExpectedPrice(),
                5.0
        );
        finishedTaskRepository.saveAndFlush(finishedTask);
    }


}
