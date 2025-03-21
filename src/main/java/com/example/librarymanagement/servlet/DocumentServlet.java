package com.example.librarymanagement.servlet;

import com.example.librarymanagement.controller.DocumentController;
import com.example.librarymanagement.model.Document;
import com.example.librarymanagement.util.GsonUtil;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/documents")
public class DocumentServlet extends HttpServlet {

    @Inject
    private DocumentController documentController;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (idParam != null) {
            // Récupérer un document par ID
            try {
                Long id = Long.parseLong(idParam);
                Document document = documentController.getDocumentById(id);
                if (document != null) {
                    response.getWriter().write(GsonUtil.toJson(document));
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("{\"error\": \"Document not found\"}");
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"Invalid document ID\"}");
            }
        } else {
            // Récupérer tous les documents
            List<Document> documents = documentController.getAllDocuments();
            response.getWriter().write(GsonUtil.toJson(documents));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Ajouter un nouveau document
        Document document = GsonUtil.fromJson(request.getReader(), Document.class);

        if (document != null && document.getTitle() != null) {
            documentController.addDocument(document);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("{\"message\": \"Document added successfully\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Invalid document data\"}");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Mettre à jour un document existant
        String idParam = request.getParameter("id");

        if (idParam != null) {
            try {
                Long id = Long.parseLong(idParam);
                Document existingDocument = documentController.getDocumentById(id);
                if (existingDocument != null) {
                    Document updatedDocument = GsonUtil.fromJson(request.getReader(), Document.class);
                    existingDocument.setTitle(updatedDocument.getTitle());
                    documentController.addDocument(existingDocument); // Mise à jour dans la BD
                    response.getWriter().write("{\"message\": \"Document updated successfully\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("{\"error\": \"Document not found\"}");
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"Invalid document ID\"}");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Missing document ID\"}");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Supprimer un document
        String idParam = request.getParameter("id");

        if (idParam != null) {
            try {
                Long id = Long.parseLong(idParam);
                Document document = documentController.getDocumentById(id);
                if (document != null) {
                    documentController.deleteDocument(id);
                    response.getWriter().write("{\"message\": \"Document deleted successfully\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("{\"error\": \"Document not found\"}");
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"Invalid document ID\"}");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Missing document ID\"}");
        }
    }
}
