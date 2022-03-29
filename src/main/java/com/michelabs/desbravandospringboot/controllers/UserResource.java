package com.michelabs.desbravandospringboot.controllers;

import com.michelabs.desbravandospringboot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    // retornando todos os usuários
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria", "maria@gmail.com","3498888888","12345");
        return ResponseEntity.ok().body(u);
    }

}
