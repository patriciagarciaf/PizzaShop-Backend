package com.Backend.Infraestructure;

import com.Backend.Domain.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
