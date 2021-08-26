package com.example.demo.Application.UserApplication;

import com.example.demo.Domain.UserDomain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;

import java.util.UUID;

@Service
public class UserApplicationImp implements UserApplication {

    private final UserRepositoryWrite userRepositoryWrite;
    private final ModelMapper modelMapper;
    private final Logger logger;

    @Autowired
    public UserApplicationImp(final UserRepositoryWrite UserRepositoryWrite, final ModelMapper modelMapper,
            final Logger logger) {

        this.userRepositoryWrite = UserRepositoryWrite;
        this.modelMapper = modelMapper;
        this.logger = logger;
    }

    @Override
    public UserDTO addClient(CreateOrUpdateUserDTO dto) {

        User user = modelMapper.map(dto, User.class);
        user.setId(UUID.randomUUID());
        user.validate("email", user.getEmail(), (email) -> this.userRepositoryWrite.exists(email));
        user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));

        this.userRepositoryWrite.add(user);
        logger.info(this.serializeObject(user, "added"));

        return modelMapper.map(user, UserDTO.class);
    }

    private String serializeObject(User user, String msg) {

        return String.format("User {id: %s, name: %s, lastName: %s, email: %s} %s succesfully.", user.getId(),
                user.getName(), user.getSurname(), user.getEmail(), msg);
    }
}
