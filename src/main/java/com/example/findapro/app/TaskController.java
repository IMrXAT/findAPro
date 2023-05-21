package com.example.findapro.app;

import com.example.findapro.core.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }


    public String index(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "index";
    }



}
