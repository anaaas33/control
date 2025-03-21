package com.example.librarymanagement.dao;

import com.example.librarymanagement.model.Document;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class DocumentDAO {

    @Inject
    private EntityManager em;

    public void save(Document document) {
        em.persist(document);
    }

    public List<Document> getAllDocuments() {
        return em.createQuery("SELECT d FROM Document d", Document.class).getResultList();
    }

    public Document findById(Long id) {
        return em.find(Document.class, id);
    }
}
