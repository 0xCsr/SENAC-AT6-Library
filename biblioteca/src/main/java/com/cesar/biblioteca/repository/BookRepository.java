/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.biblioteca.repository;

import com.cesar.biblioteca.model.Book;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author cesar
 */
public class BookRepository {
    
    private final HashMap<UUID, Book> books = new HashMap<>();

    public void save(Book book) {
        if (book == null) throw new RuntimeException("Cannot save null book");
        if (book.getId() == null) throw new RuntimeException("Book must have an ID");

        books.put(book.getId(), book);
    }

    public Optional<Book> findById(UUID id) {
        return Optional.ofNullable(books.get(id));
    }

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public void deleteById(UUID id) {
        if (!books.containsKey(id)) throw new RuntimeException("Book not found");
        
        books.remove(id);
    }

    public List<Book> findByTitle(String title) {
        return books.values()
                .stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
}
