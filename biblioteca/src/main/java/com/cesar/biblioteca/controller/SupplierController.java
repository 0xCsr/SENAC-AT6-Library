/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.controller;

import com.cesar.biblioteca.model.Supplier;
import com.cesar.biblioteca.service.SupplierService;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author cesar
 */
public class SupplierController {
    
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    public void create(Supplier supplier) {
        supplierService.create(supplier);
    }

    public Supplier findById(UUID id) {
        return supplierService.findById(id);
    }

    public List<Supplier> findAll() {
        return supplierService.findAll();
    }

    public void delete(UUID id) {
        supplierService.delete(id);
    }
}
