/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cesar.biblioteca.repository;

import com.cesar.biblioteca.model.User;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author cesar
 */
public class UserRepository {
    private final HashMap<UUID, User> users = new HashMap<>();
    
    public void save(User user) {
        if (user == null) throw new RuntimeException("Cannot save a null object");
        if (user.getId() == null) throw new RuntimeException("Cannot save with empty id");
        
        users.put(user.getId(), user);
    }
    
    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(users.get(id));
    }
    
    public Optional<User> findByUsername(String username) {
        return users.values().stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }
    
    public void deleteById(UUID id) {
        if (!users.containsKey(id)) throw new RuntimeException("User not found");
        
        users.remove(id);
    }
}
