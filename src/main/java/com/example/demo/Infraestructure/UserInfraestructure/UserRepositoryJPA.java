package com.example.demo.Infraestructure.UserInfraestructure;

import java.util.UUID;

import com.example.demo.Domain.UserDomain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepositoryJPA extends JpaRepository<User, UUID>{
    
    final String sqlExists = """
                                SELECT CASE WHEN COUNT(u)>0 THEN true ELSE false 
                                END FROM User u WHERE u.email = :email
                            """;
    User findByName(@Param("name") String name);

    
    @Query(sqlExists)
    boolean exists(@Param("email") String email);
}
