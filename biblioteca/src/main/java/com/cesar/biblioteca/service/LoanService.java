/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.service;

import com.cesar.biblioteca.model.Book;
import com.cesar.biblioteca.model.Loan;
import com.cesar.biblioteca.model.User;
import com.cesar.biblioteca.model.dto.LoanRequest;
import com.cesar.biblioteca.repository.BookRepository;
import com.cesar.biblioteca.repository.LoanRepository;
import com.cesar.biblioteca.repository.UserRepository;

import java.time.LocalDate;
import java.time.Instant;
import java.util.UUID;

/**
 *
 * @author cesar
 */
public class LoanService {
 
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public LoanService(LoanRepository loanRepository,
                       BookRepository bookRepository,
                       UserRepository userRepository) {

        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Loan createLoan(LoanRequest request) {
        if (request.loanDays() < 1 || request.loanDays() > 7)
            throw new RuntimeException("Loan days must be between 1 and 7");
        
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getQuantity() <= 0)
            throw new RuntimeException("Book not available");

        book.setQuantity(book.getQuantity() - 1);

        LocalDate today = LocalDate.now();

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(today);
        loan.setDueDate(today.plusDays(request.loanDays()));
        loan.setReturnDate(null);
        
        loanRepository.save(loan);

        return loan;
    }

    public void returnBook(UUID loanId) {

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (loan.getReturnDate() != null)
            throw new RuntimeException("Book already returned");

        // seta data de devolução
        loan.setReturnDate(LocalDate.now());

        // devolve estoque
        Book book = loan.getBook();
        book.setQuantity(book.getQuantity() + 1);

        loanRepository.save(loan);
    }

    public Loan findById(UUID id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }
}
