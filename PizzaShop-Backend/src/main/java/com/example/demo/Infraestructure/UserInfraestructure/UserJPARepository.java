package com.example.demo.Infraestructure.UserInfraestructure;

import java.util.UUID;

import com.example.demo.Domain.UserDomain.User;
import org.springframework.data.jpa.repository.JpaRepository;






public interface UserJPARepository extends JpaRepository<User, UUID>{

    
    // User findByEmail(@Param("email") String email);

    // @Query("SELECT u FROM User u WHERE (:name IS NULL OR u.name LIKE :name) AND (:email IS NULL OR u.email LIKE :email)")
    // List<User> findByCriteria(@Param("name") String name, @Param("email") String lastName, Pageable pageable);

}