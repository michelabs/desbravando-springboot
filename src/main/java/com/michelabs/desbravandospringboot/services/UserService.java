package com.michelabs.desbravandospringboot.services;

import com.michelabs.desbravandospringboot.entities.User;
import com.michelabs.desbravandospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;


    public List<User> findAllUsers() {
       return userRepository.findAll();
    }

    public User findUserById(Long id) {
        Optional<User> findUserById = userRepository.findById(id);
        return findUserById.get();
    }

    public User insertUser (User user) {
        return userRepository.save(user);
    }

}
