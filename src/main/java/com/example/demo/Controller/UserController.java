package com.example.demo.Controller;

import javax.validation.Valid;

//import java.security.SecureRandom;

import com.example.demo.Application.UserApplication.CreateOrUpdateUserDTO;
import com.example.demo.Application.UserApplication.UserApplication;
import com.example.demo.Application.UserApplication.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/users")
public class UserController {

    private final UserApplication userApplication;
	//private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserController(final UserApplication userApplication) {
        this.userApplication = userApplication;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@Valid @RequestBody final CreateOrUpdateUserDTO userDto){
    //    userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        UserDTO userApplication = this.userApplication.addClient(userDto);
        return ResponseEntity.status(201).body(userApplication);
    }
}
