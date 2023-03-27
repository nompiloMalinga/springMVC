package com.example.SpringMvcFirstProject.Service;

import com.example.SpringMvcFirstProject.Model.UserInformation;
import com.example.SpringMvcFirstProject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements userService {
    @Autowired
    private UserRepo userRepo;


    @Override
    public void register(UserInformation userInformation) {
        userRepo.save(userInformation);

    }
}
