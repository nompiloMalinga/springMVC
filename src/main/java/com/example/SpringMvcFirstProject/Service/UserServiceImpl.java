package com.example.SpringMvcFirstProject.Service;

import com.example.SpringMvcFirstProject.Model.UserInformation;
import com.example.SpringMvcFirstProject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements userService {
    @Autowired
    private UserRepo userRepo;


    @Override
    public void register(UserInformation userInformation) {
        userRepo.save(userInformation);

    }

    @Override
    public UserInformation findByUserNameAndPassword(String userName, String password) {
        return userRepo.findByUserNameAndPassword(userName,password);
    }


}
