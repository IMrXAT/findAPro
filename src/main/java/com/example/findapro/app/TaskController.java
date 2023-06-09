package com.example.findapro.app;


import com.example.findapro.core.task.TaskDto;
import com.example.findapro.core.task.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }


    @GetMapping("/tasks")
    public String tasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/adding-task")
    public String addingTaskPage(Model model){
        return "adding_task";
    }



    @PostMapping("/adding-task")
    public String addNewTask(@ModelAttribute TaskDto newTask, Authentication authentication){
        taskService.createTask(newTask, authentication.getName());
        return "redirect:/";
    }


    @PostMapping("/delete/tasks/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        taskService.delete(taskId);
        return "redirect:/tasks";
    }


    @PostMapping("/close/tasks/{taskId}")
    public String closeTask(@PathVariable Long taskId, Authentication authentication){
        taskService.closeTask(taskId, authentication.getName());
        return "redirect:/tasks";
    }



}
