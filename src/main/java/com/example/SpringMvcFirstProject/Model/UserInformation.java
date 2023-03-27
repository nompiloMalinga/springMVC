package com.example.SpringMvcFirstProject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "userName",nullable = false,unique = true, length = 15)
    private String userName;
    @Column( name = "password",nullable = false, length = 15)
    private String password;

}
