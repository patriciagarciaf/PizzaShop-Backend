package com.example.demo.Controller;

import javax.validation.Valid;
import com.example.demo.Application.UserApplication.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserApplication userApplication;

    @Autowired
    public UserController(final UserApplication userApplication) {
        this.userApplication = userApplication;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody CreateOrUpdateUserDTO dto) {
        UserDTO userDTO = this.userApplication.addClient(dto);

        return ResponseEntity.status(201).body(userDTO);
    }
}
