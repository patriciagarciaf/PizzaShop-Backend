package com.example.demo.Controller;

import java.util.UUID;

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
    public ResponseEntity<?> create(@Valid @RequestBody CreateUserDTO dto) {
        UserDTO userDTO = this.userApplication.addClient(dto);

        return ResponseEntity.status(201).body(userDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable UUID id,  @RequestBody UpdateUserDTO dto) {
        UserDTO newUserDTO = this.userApplication.update(id, dto);
        return ResponseEntity.ok(newUserDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> get(@Valid @PathVariable UUID id) {
        UserDTO userDTO = this.userApplication.get(id);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable UUID id) {
        this.userApplication.delete(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(@RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.status(200).body(this.userApplication.getAll(email, page, size));
    }
}
