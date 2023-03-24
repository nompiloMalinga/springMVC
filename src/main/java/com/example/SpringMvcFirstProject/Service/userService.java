package com.example.SpringMvcFirstProject.Service;

import com.example.SpringMvcFirstProject.Model.user_information;
import com.example.SpringMvcFirstProject.Repository.userInterfaceRepo;

import java.util.List;

public class userService {
    private userInterfaceRepo repo;
    public userService(){

    }

    public userService(userInterfaceRepo repo) {
        this.repo = repo;
    }

    public List<user_information> listAll(){

        return (List<user_information>) repo.findAll();
    }
    public void save(user_information user){
        repo.save(user);

    }



}
