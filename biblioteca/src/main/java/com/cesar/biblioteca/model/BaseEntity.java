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
public abstract class BaseEntity {
    
    private UUID id;
    private Instant createdAt;
    private Instant updatedAt;
    
    public BaseEntity() {
        setId();
        setCreatedAt();
        setUpdatedAt();
    }
    
    public BaseEntity(UUID id, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    private void setId() {
        this.id = UUID.randomUUID();
    }
    
    public UUID getId() {
        return this.id;
    }
    
    private void setCreatedAt() {
        this.createdAt = Instant.now();
    }
    
    public Instant getCreatedAt() {
        return this.createdAt;
    }
    
    private void setUpdatedAt() {
        this.updatedAt = Instant.now();
    }
    
    public Instant getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void update() {
        setUpdatedAt();
    }
}
