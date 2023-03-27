package com.example.SpringMvcFirstProject.Repository;

import com.example.SpringMvcFirstProject.Model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserInformation,Long> {
}
