/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author cesar
 */
public class Loan extends BaseEntity {

    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate dueDate;   // padrão será de 7 dias
    private LocalDate returnDate;
    
    public Loan() {
        super();
    }
    
    public Loan(UUID id, Instant createdAt, Instant updatedAt, User user, Book book, LocalDate loanDate, LocalDate dueDate, LocalDate returnDate) {
        super(id, createdAt, updatedAt);
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }
    
        public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
