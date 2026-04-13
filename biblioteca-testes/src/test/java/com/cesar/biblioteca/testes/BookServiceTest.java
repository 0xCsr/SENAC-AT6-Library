/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.cesar.biblioteca.testes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cesar
 */
public class BookServiceTest {
    
    LibraryRules rules = new LibraryRules();

    @Test
    void shouldAcceptValidBook() {
        assertTrue(rules.isBookValid("Clean Code", 2));
    }

    @Test
    void shouldRejectBookWithEmptyTitle() {
        assertFalse(rules.isBookValid("", 2));
    }

    @Test
    void shouldRejectBookWithNegativeQuantity() {
        assertFalse(rules.isBookValid("Java", -1));
    }
}
