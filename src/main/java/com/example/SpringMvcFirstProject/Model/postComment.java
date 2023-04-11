package com.example.SpringMvcFirstProject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;

@Data //used to generate getter and setter methods for all fields in a Java class
@AllArgsConstructor //generates a constructor with arguments for all fields in a Java class.
@NoArgsConstructor// generates a no-argument constructor for a Java class.
@Entity//used to mark a Java class as a database entity. An entity represents a table in a relational database.
@Table(name = "comments")
public class postComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "commenter_name",nullable = false,unique = true, length = 15)
    private String commenter_name;

    @Column(name = "comment_text",nullable = false)
    private String comment_text;
}
