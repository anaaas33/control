package com.example.librarymanagement.servlet;

import com.example.librarymanagement.controller.BorrowController;
import com.example.librarymanagement.model.Borrow;
import com.example.librarymanagement.util.GsonUtil;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/borrows")
public class BorrowServlet extends HttpServlet {

    @Inject
    private BorrowController borrowController;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        String idParam = request.getParameter("id");

        if (idParam != null) {
            try {
                Long id = Long.parseLong(idParam);
                Borrow borrow = borrowController.getBorrowById(id);
                if (borrow != null) {
                    response.getWriter().write(GsonUtil.toJson(borrow));
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("{\"error\": \"Borrow not found\"}");
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"Invalid borrow ID\"}");
            }
        } else {
            List<Borrow> borrows = borrowController.getAllBorrows();
            response.getWriter().write(GsonUtil.toJson(borrows));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Borrow borrow = GsonUtil.fromJson(request.getReader(), Borrow.class);
        if (borrow != null && borrow.getUser() != null && borrow.getDocument() != null) {
            borrowController.borrowDocument(borrow);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("{\"message\": \"Borrow created successfully\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Invalid borrow data\"}");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                Long id = Long.parseLong(idParam);
                Borrow borrow = borrowController.getBorrowById(id);
                if (borrow != null) {
                    borrowController.deleteBorrow(id);
                    response.getWriter().write("{\"message\": \"Borrow deleted successfully\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("{\"error\": \"Borrow not found\"}");
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"Invalid borrow ID\"}");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Missing borrow ID\"}");
        }
    }
}
