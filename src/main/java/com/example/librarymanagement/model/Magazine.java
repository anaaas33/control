package com.example.librarymanagement.model;

import jakarta.inject.Named;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Named
@Transactional
@DiscriminatorValue("Magazine")
public class Magazine extends Document {

    private String publisher;
    private String issueNumber;

    public Magazine() {}

    public Magazine(String title, String publisher, String issueNumber) {
        super(title, new java.util.Date());
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

    // Getters et Setters
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getIssueNumber() { return issueNumber; }
    public void setIssueNumber(String issueNumber) { this.issueNumber = issueNumber; }
}
