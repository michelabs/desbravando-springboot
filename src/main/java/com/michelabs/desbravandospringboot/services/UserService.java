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

    public void deleteUserById (Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser (Long id, User user) {
        User entity = userRepository.getById(id);
        updateData(entity, user);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

}
