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
public class UserServiceTest {
    
    LibraryRules rules = new LibraryRules();

    @Test
    void shouldAcceptValidUser() {
        assertTrue(rules.isUserValid("john"));
    }

    @Test
    void shouldRejectEmptyUsername() {
        assertFalse(rules.isUserValid(""));
    }

    @Test
    void shouldRejectNullUsername() {
        assertFalse(rules.isUserValid(null));
    }
}
