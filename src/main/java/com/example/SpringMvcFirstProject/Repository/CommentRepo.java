package com.example.SpringMvcFirstProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringMvcFirstProject.Model.postComment;
import org.springframework.stereotype.Repository;
//provides a set of common methods for interacting with a database.
@Repository
public interface CommentRepo extends JpaRepository<postComment,Long> {
}
