package com.example.librarymanagement.controller;

import com.example.librarymanagement.dao.BorrowDAO;
import com.example.librarymanagement.model.Borrow;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@RequestScoped
public class BorrowController {

    @Inject
    private BorrowDAO borrowDAO;

    @Transactional
    public void borrowDocument(Borrow borrow) {
        borrowDAO.save(borrow);
    }

    public List<Borrow> getAllBorrows() {
        return borrowDAO.getAllBorrows();
    }

    public Borrow getBorrowById(Long id) {
        return borrowDAO.findById(id);
    }
}
