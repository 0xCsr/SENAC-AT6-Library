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
public class Book extends BaseEntity {
    
    private String title;
    private String author;
    private String publisher;
    private LocalDate publicationDate;
    private String genre;
    private Supplier supplier;
    private Integer quantity;
    
    public Book() {
        super();
    }
    
    public Book(UUID id, Instant createdAt, Instant updatedAt, String title, String author, String publisher, LocalDate publicationDate, String genre, Supplier supplier, Integer quantity) {
        super(id, createdAt, updatedAt);
        
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.genre = genre;
        this.supplier = supplier;
        this.quantity = quantity;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
