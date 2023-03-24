package com.example.SpringMvcFirstProject.Repository;

import com.example.SpringMvcFirstProject.Model.user_information;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userInterfaceRepo extends CrudRepository<user_information,Long> {
}
