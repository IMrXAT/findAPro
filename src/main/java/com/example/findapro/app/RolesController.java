package com.example.findapro.app;

import com.example.findapro.core.role.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RolesController {

    private final RoleService roleService;

    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public String roles(Model model){
        model.addAttribute("roles", roleService.getRoles());
        return "roles";
    }

}
