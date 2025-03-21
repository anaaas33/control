package com.example.librarymanagement.model;

import jakarta.inject.Named;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import java.util.Date;

@Entity
@Named
@Transactional
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
    private Document document;

    @Temporal(TemporalType.DATE)
    private Date dateBorrow;

    @Temporal(TemporalType.DATE)
    private Date returnDate;

    public Borrow() {}

    public Borrow(User user, Document document, Date dateBorrow, Date returnDate) {
        this.user = user;
        this.document = document;
        this.dateBorrow = dateBorrow;
        this.returnDate = returnDate;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Document getDocument() { return document; }
    public void setDocument(Document document) { this.document = document; }

    public Date getDateBorrow() { return dateBorrow; }
    public void setDateBorrow(Date dateBorrow) { this.dateBorrow = dateBorrow; }

    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }
}
