package com.example.librarymanagement.dao;

import com.example.librarymanagement.model.Borrow;
import com.example.librarymanagement.util.JpaUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BorrowDAO {

    public void save(Borrow borrow) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(borrow);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Borrow> getAllBorrows() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("SELECT b FROM Borrow b", Borrow.class).getResultList();
    }
}
