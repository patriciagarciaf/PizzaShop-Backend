package com.example.demo.Infraestructure.UserInfraestructure;

import com.example.demo.Domain.UserDomain.*;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserRepositoryImp implements UserRepositoryWrite{   //, UserRepositoryRead{

    private final UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public UserRepositoryImp(final UserRepositoryJPA userRepositoryJPA){
        this.userRepositoryJPA = userRepositoryJPA;
    }   

    @Override
    public void add(User user) {
        this.userRepositoryJPA.save(user);
    }

    @Override
    public boolean exists(String email) {
        return this.userRepositoryJPA.exists(email);
    }
}
    

    

