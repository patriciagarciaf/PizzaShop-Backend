package com.example.demo.Application.UserApplication;



import com.example.demo.Domain.UserDomain.User;
import com.example.demo.Domain.UserDomain.UserRepository;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;

import java.util.UUID;

@Service
public class UserApplicationImp implements UserApplication{

    private final Logger log;
    private final UserRepository userRepository;

    UserApplicationImp(final Logger log, final UserRepository userRepository) {
        this.log = log;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO addClient(CreateOrUpdateUserDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(dto, User.class);
        user.id=UUID.randomUUID();
        user.validate();
        this.userRepository.addClient(user);
        return modelMapper.map(user, UserDTO.class);
    }
}

