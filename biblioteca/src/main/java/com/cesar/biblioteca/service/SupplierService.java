/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.service;

import com.cesar.biblioteca.model.Supplier;
import com.cesar.biblioteca.repository.SupplierRepository;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author cesar
 */
public class SupplierService {
    
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void create(Supplier supplier) {

        if (supplier == null)
            throw new RuntimeException("Supplier cannot be null");

        if (supplier.getCnpj() == null || supplier.getCnpj().isBlank())
            throw new RuntimeException("CNPJ is required");

        supplierRepository.save(supplier);
    }

    public Supplier findById(UUID id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public void delete(UUID id) {
        supplierRepository.deleteById(id);
    }
}
