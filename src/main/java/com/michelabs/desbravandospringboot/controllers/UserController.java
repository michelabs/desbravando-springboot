package com.michelabs.desbravandospringboot.controllers;

import com.michelabs.desbravandospringboot.entities.User;
import com.michelabs.desbravandospringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // retornando todos os usuários
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> listUsers = userService.findAllUsers();
        return ResponseEntity.ok().body(listUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User findUserById = userService.findUserById(id);
        return ResponseEntity.ok().body(findUserById);
    }

}
