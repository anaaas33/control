package com.example.librarymanagement.controller;

import com.example.librarymanagement.dao.DocumentDAO;
import com.example.librarymanagement.model.Document;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@RequestScoped
public class DocumentController {

    @Inject
    private DocumentDAO documentDAO;

    @Transactional
    public void addDocument(Document document) {
        documentDAO.save(document);
    }

    public List<Document> getAllDocuments() {
        return documentDAO.getAllDocuments();
    }

    public Document getDocumentById(Long id) {
        return documentDAO.findById(id);
    }
}
