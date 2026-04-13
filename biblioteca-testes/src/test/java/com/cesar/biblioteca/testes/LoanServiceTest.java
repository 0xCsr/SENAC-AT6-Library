/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.testes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cesar
 */
public class LoanServiceTest {
    
    LibraryRules rules = new LibraryRules();

    @Test
    void shouldAllowBorrowWhenStockExists() {
        assertTrue(rules.canBorrowBook(3));
    }

    @Test
    void shouldRejectBorrowWhenNoStock() {
        assertFalse(rules.canBorrowBook(0));
    }

    @Test
    void shouldAcceptValidLoanDays() {
        assertTrue(rules.isLoanDaysValid(5));
    }

    @Test
    void shouldRejectInvalidLoanDays() {
        assertFalse(rules.isLoanDaysValid(10));
    }
}
