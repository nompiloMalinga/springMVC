package com.example.SpringMvcFirstProject;

import com.example.SpringMvcFirstProject.Model.UserInformation;
import com.example.SpringMvcFirstProject.Repository.UserRepo;
import org.junit.jupiter.api.* ;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

/**
 * By default, when you use @DataJpaTest, Spring Boot configures an in-memory database
 * for testing purposes. Inorder to run the tests against a real database we use the
 *@AutoConfigureTestDatabase annotation
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class DatabaseTests {
    @Autowired UserRepo userRepo;

    @Test
    public void testCreate(){
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName("mbali");
        userInformation.setPassword("45673");
        UserInformation savedUser= userRepo.save(userInformation);
        Assertions.assertThat(savedUser.getId()).isNotNull();
        Assertions.assertThat(savedUser).isNotNull();
    }



}
