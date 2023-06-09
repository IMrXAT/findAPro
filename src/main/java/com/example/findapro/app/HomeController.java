package com.example.findapro.app;


import com.example.findapro.core.user.UserRepository;
import com.example.findapro.core.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserRepository userRepository, UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }


    @GetMapping("/admin")
    public String adminPage(Model model, Authentication authentication){
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        model.addAttribute("allUsers", userService.allUsers());
        model.addAttribute("admin", userDetails);
        return "admin";
    }

}
