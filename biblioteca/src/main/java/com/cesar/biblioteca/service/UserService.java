/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.cesar.biblioteca.model.Role;
import com.cesar.biblioteca.model.User;
import com.cesar.biblioteca.model.dto.LoginRequest;
import com.cesar.biblioteca.model.dto.RegisterRequest;
import com.cesar.biblioteca.repository.UserRepository;

/**
 *
 * @author cesar
 */
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void register(RegisterRequest request) {
        if (request == null) throw new RuntimeException("Request cannot be null");
        if (request.username() == null || request.username().isBlank()) throw new RuntimeException("Username is required");
        if (userRepository.findByUsername(request.username()).isPresent()) throw new RuntimeException("Username already exists");

        User user = new User( );
        user.setName(request.name());
        user.setUsername(request.username());
        user.setPassword(BCrypt.withDefaults().hashToString(12, request.password().toCharArray()));
        user.setRole(Role.USER);
        user.setAddress(request.address());
        user.setPhone(request.phone());
        
        userRepository.save(user);
    }
    
    public User login(LoginRequest request) {
        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean valid = BCrypt.verifyer()
                .verify(request.password().toCharArray(), user.getPassword())
                .verified;

        if (!valid) throw new RuntimeException("Invalid credentials");
        
        return user;
    }
}