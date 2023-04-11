package com.example.SpringMvcFirstProject.Service;

import com.example.SpringMvcFirstProject.Model.UserInformation;

public interface userService {
    void register(UserInformation userInformation);
    UserInformation findByUserNameAndPassword(String userName,String password);
}
