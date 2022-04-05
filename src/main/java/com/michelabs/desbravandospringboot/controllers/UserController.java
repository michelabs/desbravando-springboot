package com.michelabs.desbravandospringboot.controllers;

import com.michelabs.desbravandospringboot.entities.User;
import com.michelabs.desbravandospringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> listUsers = userService.findAllUsers();
        return ResponseEntity.ok().body(listUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User findUserById = userService.findUserById(id);
        return ResponseEntity.ok().body(findUserById);
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        user = userService.insertUser(user);
        URI createdWithSucessfull = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(createdWithSucessfull).body(user);
    }

}
