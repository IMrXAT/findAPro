package com.example.findapro.app;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserProfileController {

    @GetMapping("/user-profile")
    public String getUserProfile(Model model, Authentication authentication){
        model.addAttribute("user", authentication.getPrincipal());
        return "user_profile";
    }

}
