package com.example.SpringMvcFirstProject;

import com.example.SpringMvcFirstProject.Model.UserInformation;
import com.example.SpringMvcFirstProject.Model.postComment;
import com.example.SpringMvcFirstProject.Repository.CommentRepo;
import com.example.SpringMvcFirstProject.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.assertj.core.api.Assertions;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
public class AppIntegratedTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CommentRepo commentRepo;

    @Test
    public void testRegisterAndLogin() throws Exception{
        mockMvc.perform(post("/registerUser")
                .param("userName","testuser")
                .param("password","testpassword")
        ).andExpect(status().isFound())
        .andExpect(redirectedUrl("/register?success"));


        mockMvc.perform(post("/loginUser")
                .param("userName","testuser")
                .param("password","testpassword")
        ).andExpect(status().isFound())
         .andExpect(redirectedUrl("/blog"));

        UserInformation userInformation = userRepo.findByUserNameAndPassword("testuser","testpassword");
        Assertions.assertThat(userInformation).isNotNull();
        assertEquals("testuser",userInformation.getUserName());
        assertEquals("testpassword",userInformation.getPassword());

    }
    @Test
    public void testBlog() throws Exception {
        UserInformation user = new UserInformation();
        user.setUserName("mbali");
        user.setPassword("password");
        userRepo.save(user);

        mockMvc.perform(post("/loginUser")
                        .param("userName", "mbali")
                        .param("password", "password")
                )
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/blog"));

        mockMvc.perform(post("/comments")
                        .param("commenter_name", "testusername")
                        .param("comment_text", "This is my first blog post.")
                )
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/blog"));

        List<postComment> blogPosts = commentRepo.findAll();
        Assertions.assertThat(blogPosts.size()).isGreaterThan(0);
    }

}

