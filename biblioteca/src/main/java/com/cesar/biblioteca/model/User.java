/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.model;

import java.time.Instant;
import java.util.UUID;

/**
 *
 * @author cesar
 */
public class User extends BaseEntity {
 
    private String name;
    private String username;
    private String password; // hash password
    private Role role;
    
    private String address; // Optional
    private String phone;   // Optional
    
    public User() {
        super();
    }
    
    public User(UUID id, Instant createdAt, Instant updatedAt, String name, String username, String password, Role role) {
        super(id, createdAt, updatedAt);
    
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public User(UUID id, Instant createdAt, Instant updatedAt, String name, String username, String password, Role role, String address, String phone) {
        super(id, createdAt, updatedAt);
    
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.address = address;
        this.phone = phone;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
