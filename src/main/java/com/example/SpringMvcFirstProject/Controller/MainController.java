package com.example.SpringMvcFirstProject.Controller;

import com.example.SpringMvcFirstProject.Model.UserInformation;
import com.example.SpringMvcFirstProject.Service.userService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private userService userRepo;

    @GetMapping("/")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserInformation());
        return "login";
    }

    @PostMapping("/loginUser")
    public String login(@ModelAttribute UserInformation user, HttpSession session, Model model) {
        UserInformation existingUser = userRepo.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        if (existingUser != null && existingUser.getUserName().equals(user.getUserName())
                && existingUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", existingUser);
            return "redirect:/blog";
        } else {
            model.addAttribute("user", new UserInformation());
            return "redirect:/?success";
        }
    }


}
