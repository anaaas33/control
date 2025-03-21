package com.example.librarymanagement.dao;

import com.example.librarymanagement.model.Borrow;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class BorrowDAO {

    @Inject
    private EntityManager em;

    public void save(Borrow borrow) {
        em.persist(borrow);
    }

    public List<Borrow> getAllBorrows() {
        return em.createQuery("SELECT b FROM Borrow b", Borrow.class).getResultList();
    }
