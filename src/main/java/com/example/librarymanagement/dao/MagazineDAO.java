package com.example.librarymanagement.dao;

import com.example.librarymanagement.model.Magazine;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class MagazineDAO {

    @Inject
    private EntityManager em;

    public void save(Magazine magazine) {
        em.persist(magazine);
    }

    public List<Magazine> getAllMagazines() {
        return em.createQuery("SELECT m FROM Magazine m", Magazine.class).getResultList();
    }

    public Magazine findById(Long id) {
        return em.find(Magazine.class, id);
    }
}
