package com.example.SpringMvcFirstProject.Controller;

import com.example.SpringMvcFirstProject.Model.UserInformation;


import com.example.SpringMvcFirstProject.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    @Autowired
    private userService service;

    @GetMapping("/register")
    public String createUser(Model model){
        UserInformation userInformation = new UserInformation();
        model.addAttribute("user",userInformation);
        return "register";
    }
    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") UserInformation userInformation){
        service.register(userInformation);
        return "redirect:/register?success";
    }



}

