package com.example.demo.Infraestructure;


import java.util.List;
import java.util.UUID;

import com.example.demo.Domain.UserDomain.User;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface UserJPARepository extends CrudRepository<User, UUID> {

    
    User findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE (:name IS NULL OR u.name LIKE :name) AND (:email IS NULL OR u.email LIKE :email)")
    List<User> findByCriteria(@Param("name") String name, @Param("email") String lastName, Pageable pageable);
}