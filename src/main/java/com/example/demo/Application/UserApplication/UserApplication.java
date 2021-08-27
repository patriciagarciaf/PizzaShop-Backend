package com.example.demo.Application.UserApplication;

import java.util.UUID;

public interface UserApplication {
    public UserDTO addClient(CreateOrUpdateUserDTO dto);

    public UserDTO update(UUID id, CreateOrUpdateUserDTO dto);

    public UserDTO get(UUID id);
}