package com.michelabs.desbravandospringboot.services;

import com.michelabs.desbravandospringboot.entities.User;
import com.michelabs.desbravandospringboot.repository.UserRepository;
import com.michelabs.desbravandospringboot.services.exceptions.DataBaseException;
import com.michelabs.desbravandospringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return findUserById.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insertUser (User user) {
        return userRepository.save(user);
    }

    public void deleteUserById (Long id) {
        try{
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public User updateUser (Long id, User user) {
        try{
            User entity = userRepository.getById(id);
            updateData(entity, user);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

}
