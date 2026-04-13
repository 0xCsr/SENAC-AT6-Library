/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.repository;

import com.cesar.biblioteca.model.Loan;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author cesar
 */

public class LoanRepository {

    private final HashMap<UUID, Loan> loans = new HashMap<>();

    public void save(Loan loan) {
        if (loan == null) throw new RuntimeException("Cannot save null loan");
        if (loan.getId() == null) throw new RuntimeException("Loan must have an ID");

        loans.put(loan.getId(), loan);
    }

    public Optional<Loan> findById(UUID id) {
        return Optional.ofNullable(loans.get(id));
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loans.values());
    }

    public void deleteById(UUID id) {
        if (!loans.containsKey(id)) throw new RuntimeException("Loan not found");
        
        loans.remove(id);
    }

    public List<Loan> findActiveLoans() {
        return loans.values()
                .stream()
                .filter(l -> l.getReturnDate() == null)
                .collect(Collectors.toList());
    }

    public List<Loan> findOverdueLoans() {
        return loans.values()
                .stream()
                .filter(l -> l.getReturnDate() == null)
                .filter(l -> l.getDueDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public List<Loan> findByUserId(UUID userId) {
        return loans.values()
                .stream()
                .filter(l -> l.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Loan> findByBookId(UUID bookId) {
        return loans.values()
                .stream()
                .filter(l -> l.getBook().getId().equals(bookId))
                .collect(Collectors.toList());
    }
}
