/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.service;

import com.cesar.biblioteca.model.Book;
import com.cesar.biblioteca.repository.BookRepository;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author cesar
 */
public class BookService {
    
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void create(Book book) {

        if (book == null) throw new RuntimeException("Book cannot be null");
        if (book.getTitle() == null || book.getTitle().isBlank()) throw new RuntimeException("Title is required");
        if (book.getQuantity() == null || book.getQuantity() < 0) throw new RuntimeException("Invalid quantity");

        bookRepository.save(book);
    }

    public Book findById(UUID id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void delete(UUID id) {
        bookRepository.deleteById(id);
    }
}
