/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cesar.biblioteca;

import com.cesar.biblioteca.model.*;
import com.cesar.biblioteca.repository.*;
import com.cesar.biblioteca.service.*;
import com.cesar.biblioteca.controller.*;
import com.cesar.biblioteca.model.dto.LoanRequest;
import com.cesar.biblioteca.model.dto.LoginRequest;
import com.cesar.biblioteca.model.dto.RegisterRequest;

/**
 *
 * @author cesar
 */
public class Biblioteca {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        BookRepository bookRepository = new BookRepository();
        LoanRepository loanRepository = new LoanRepository();
        SupplierRepository supplierRepository = new SupplierRepository();

        UserService userService = new UserService(userRepository);
        BookService bookService = new BookService(bookRepository);
        LoanService loanService = new LoanService(loanRepository, bookRepository, userRepository);
        SupplierService supplierService = new SupplierService(supplierRepository);

        UserController userController = new UserController(userService);
        BookController bookController = new BookController(bookService);
        LoanController loanController = new LoanController(loanService);
        SupplierController supplierController = new SupplierController(supplierService);

        System.out.println("=== INICIANDO TESTES ===");

        RegisterRequest register = new RegisterRequest(
                "João Silva",
                "joao",
                "1234",
                "Rua A",
                "99999999"
        );

        userController.register(register);

        User user = userController.login(new LoginRequest("joao", "1234"));
        System.out.println("Login OK: " + user.getUsername());

        Supplier supplier = new Supplier();
        supplier.setName("Editora ABC");
        supplier.setCnpj("12.345.678/0001-99");
        supplier.setPhone("1111-1111");

        supplierController.create(supplier);
        System.out.println("Fornecedor criado!");

        Book book = new Book();
        book.setTitle("Java Básico");
        book.setAuthor("Autor X");
        book.setPublisher("Editora ABC");
        book.setGenre("Tecnologia");
        book.setQuantity(2);
        book.setSupplier(supplier);

        bookController.create(book);

        Book savedBook = bookController.findAll().get(0);
        System.out.println("Livro criado: " + savedBook.getTitle());

        Loan loan = loanController.createLoan(new LoanRequest(user.getId(), savedBook.getId(), 5));
        System.out.println("Empréstimo realizado: " + loan.getId());

        loanController.returnBook(loan.getId());
        System.out.println("Livro devolvido!");
        System.out.println("Estoque final: " + savedBook.getQuantity());

        System.out.println("=== TESTES FINALIZADOS ===");
    }
}
