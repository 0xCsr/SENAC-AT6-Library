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
public class Supplier extends BaseEntity {

    private String name;
    private String cnpj;
    private String phone;
    
    public Supplier() {
        super();
    }
    
    public Supplier(UUID id, Instant createdAt, Instant updatedAt, String name, String cnpj, String phone) {
        super(id, createdAt, updatedAt);
        
        this.name = name;
        this.cnpj = cnpj;
        this.phone = phone;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
