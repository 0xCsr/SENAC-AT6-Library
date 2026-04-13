/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.testes;

/**
 *
 * @author cesar
 */
public class LibraryRules {
    
    public boolean isBookValid(String title, int quantity) {
        return title != null && !title.isBlank() && quantity >= 0;
    }

    public boolean canBorrowBook(int stock) {
        return stock > 0;
    }

    public boolean isLoanDaysValid(int days) {
        return days >= 1 && days <= 7;
    }

    public boolean isUserValid(String username) {
        return username != null && !username.isBlank();
    }

    public boolean isSupplierValid(String cnpj) {
        return cnpj != null && !cnpj.isBlank();
    }
}
