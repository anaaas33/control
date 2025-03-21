package com.example.librarymanagement.model;

import jakarta.inject.Named;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Named
@Transactional
@DiscriminatorValue("Book")
public class Book extends Document {

    private String author;
    private String isbn;

    public Book() {}

    public Book(String title, String author, String isbn) {
        super(title, new java.util.Date());
        this.author = author;
        this.isbn = isbn;
    }

    // Getters et Setters
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}
