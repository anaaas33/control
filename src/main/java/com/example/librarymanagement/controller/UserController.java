package com.example.librarymanagement.controller;

import com.example.librarymanagement.dao.UserDAO;
import com.example.librarymanagement.model.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@RequestScoped
public class UserController {

    @Inject
    private UserDAO userDAO;

    @Transactional
    public void registerUser(User user) {
        userDAO.save(user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(Long id) {
        return userDAO.findById(id);
    }
}
