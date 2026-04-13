/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.repository;

import com.cesar.biblioteca.model.Supplier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author cesar
 */
public class SupplierRepository {
    
    private final HashMap<UUID, Supplier> suppliers = new HashMap<>();

    public void save(Supplier supplier) {
        if (supplier == null) throw new RuntimeException("Cannot save null supplier");
        if (supplier.getId() == null) throw new RuntimeException("Supplier must have an ID");

        suppliers.put(supplier.getId(), supplier);
    }

    public Optional<Supplier> findById(UUID id) {
        return Optional.ofNullable(suppliers.get(id));
    }

    public List<Supplier> findAll() {
        return new ArrayList<>(suppliers.values());
    }

    public void deleteById(UUID id) {
        if (!suppliers.containsKey(id)) throw new RuntimeException("Supplier not found");
        
        suppliers.remove(id);
    }

    public Optional<Supplier> findByCnpj(String cnpj) {
        return suppliers.values()
                .stream()
                .filter(s -> s.getCnpj().equals(cnpj))
                .findFirst();
    }
}
