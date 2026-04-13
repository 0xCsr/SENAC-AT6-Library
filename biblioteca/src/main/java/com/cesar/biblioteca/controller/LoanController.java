/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.controller;

import com.cesar.biblioteca.model.Loan;
import com.cesar.biblioteca.model.dto.LoanRequest;
import com.cesar.biblioteca.service.LoanService;

import java.util.UUID;

/**
 *
 * @author cesar
 */
public class LoanController {
    
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    public Loan createLoan(LoanRequest request) {
        return loanService.createLoan(request);
    }

    public void returnBook(UUID loanId) {
        loanService.returnBook(loanId);
    }

    public Loan findById(UUID id) {
        return loanService.findById(id);
    }
}
