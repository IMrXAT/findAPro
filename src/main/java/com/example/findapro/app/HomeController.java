package com.example.findapro.app;


import com.example.findapro.core.role.RoleService;
import com.example.findapro.core.task.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final TaskService taskService;
    private final RoleService roleService;



    public HomeController(TaskService taskService, RoleService roleService) {
        this.taskService = taskService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String index(Model model, Authentication authentication){
        model.addAttribute("authentication", authentication);
        return "index";
    }
    @GetMapping("/tasks")
    public String tasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

}
