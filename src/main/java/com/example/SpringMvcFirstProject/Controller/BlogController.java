package com.example.SpringMvcFirstProject.Controller;

import com.example.SpringMvcFirstProject.Repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.SpringMvcFirstProject.Model.postComment;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private CommentRepo commentRepo;

    @GetMapping("/blog")
    public String ShowComments(Model model) {
        List<postComment> comments = commentRepo.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new postComment());
        return "blog";

    }

    @PostMapping("/comments")
    public String addComment(@ModelAttribute postComment comment) {
        commentRepo.save(comment);
        return "redirect:/blog";
    }

}
