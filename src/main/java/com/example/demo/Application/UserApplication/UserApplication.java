package com.example.demo.Application.UserApplication;

import java.util.*;
import com.example.demo.Domain.UserDomain.UserProjection;

public interface UserApplication {
    public UserDTO addClient(CreateUserDTO dto);

    public UserDTO update(UUID id, UpdateUserDTO dto);

    public UserDTO get(UUID id);

    public void delete(UUID id);

    public List<UserProjection> getAll(String name, int page, int size);
}