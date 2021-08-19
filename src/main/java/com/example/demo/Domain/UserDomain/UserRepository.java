package com.example.demo.Domain.UserDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    public void add(User user);

    public Optional<User> get(UUID id);
    public List<User> getAll(UUID id, String name, String surname,String email, String Password, String role , int page, int size);

    public void update(User user);

    public void delete(User user);

}
