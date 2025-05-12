package com.desafio.neki.services;

import com.desafio.neki.controllers.UserController;
import com.desafio.neki.exception.ResourceNotFoundException;
import com.desafio.neki.models.User;
import com.desafio.neki.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado","Id not found"));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado","Username not found"));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado","Email not found"));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
       if(!userRepository.existsById(id)) {
           throw new ResourceNotFoundException("Usuario nao encontrado","Id not found");
       }
        User user = getUserById(id);
        userRepository.delete(user);
    }

}
