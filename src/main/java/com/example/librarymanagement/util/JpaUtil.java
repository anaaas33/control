package com.example.librarymanagement.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class JpaUtil {

    @Produces
    @PersistenceContext(unitName = "LibraryPU")
    private EntityManager em;
}
