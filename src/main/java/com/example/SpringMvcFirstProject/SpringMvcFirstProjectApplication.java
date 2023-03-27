package com.example.SpringMvcFirstProject;

import com.example.SpringMvcFirstProject.Repository.UserRepo;
import com.example.SpringMvcFirstProject.Service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringMvcFirstProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringMvcFirstProjectApplication.class, args);
	}


}
