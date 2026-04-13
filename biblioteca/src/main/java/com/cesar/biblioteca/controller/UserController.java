/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.controller;

import com.cesar.biblioteca.model.User;
import com.cesar.biblioteca.model.dto.LoginRequest;
import com.cesar.biblioteca.model.dto.RegisterRequest;
import com.cesar.biblioteca.service.UserService;

/**
 *
 * @author cesar
 */
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    public void register(RegisterRequest request) {
        userService.register(request);
    }
    
    public User login(LoginRequest request) {
        return userService.login(request);
    }
}
