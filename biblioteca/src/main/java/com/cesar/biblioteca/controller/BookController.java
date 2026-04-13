/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.controller;

import com.cesar.biblioteca.model.Book;
import com.cesar.biblioteca.service.BookService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author cesar
 */
public class BookController {
    
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    public void create(Book book) {
        bookService.create(book);
    }

    public Book findById(UUID id) {
        return bookService.findById(id);
    }

    public List<Book> findAll() {
        return bookService.findAll();
    }

    public void delete(UUID id) {
        bookService.delete(id);
    }
}
