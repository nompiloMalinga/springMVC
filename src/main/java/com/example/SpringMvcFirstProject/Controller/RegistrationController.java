package com.example.SpringMvcFirstProject.Controller;

import com.example.SpringMvcFirstProject.Model.user_information;
import com.example.SpringMvcFirstProject.Service.userService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/register", method = RequestMethod.POST)
public class RegistrationController {

    private userService service;

    public RegistrationController() {
        super();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new user_information());
        return "register";
    }
    @PostMapping
    public String saveUserDetails(@ModelAttribute("user") user_information userInformation){
        service.save(userInformation);
        return  "redirect:/register?success";
    }
}
