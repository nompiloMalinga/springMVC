package com.example.SpringMvcFirstProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping ("/")

    public String login(){

        return "Index";
    }



}
