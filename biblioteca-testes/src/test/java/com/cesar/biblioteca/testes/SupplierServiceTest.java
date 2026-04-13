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
public class SupplierServiceTest {
    
    LibraryRules rules = new LibraryRules();

    @Test
    void shouldAcceptValidSupplier() {
        assertTrue(rules.isSupplierValid("12.345.678/0001-99"));
    }

    @Test
    void shouldRejectEmptyCnpj() {
        assertFalse(rules.isSupplierValid(""));
    }

    @Test
    void shouldRejectNullCnpj() {
        assertFalse(rules.isSupplierValid(null));
    }
}
