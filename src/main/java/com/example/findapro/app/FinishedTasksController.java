package com.example.findapro.app;

import com.example.findapro.core.finishedTask.FinishedTaskRepository;
import com.example.findapro.core.finishedTask.FinishedTasksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinishedTasksController {

    private final FinishedTasksService finishedTasksService;

    public FinishedTasksController(FinishedTasksService finishedTasksService) {
        this.finishedTasksService = finishedTasksService;
    }

    @GetMapping("/finished-tasks")
    public String tasks(Model model){
        model.addAttribute("tasks", finishedTasksService.getFinishedTasks());
        return "finished_tasks";
    }
}
