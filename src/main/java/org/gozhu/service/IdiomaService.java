package org.gozhu.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gozhu.model.Idioma;

import java.util.List;

public class IdiomaService {
    private final EntityManagerFactory emf;

    public IdiomaService() {
        this.emf = Persistence.createEntityManagerFactory("oneToManyExample");
    }

    public void crearIdioma(Idioma idioma) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(idioma);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Idioma> obtenerIdiomas() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT i FROM Idioma i LEFT JOIN FETCH i.libros", Idioma.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Long contarIdiomas() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT COUNT(i) FROM Idioma i", Long.class).getSingleResult();
        } finally {
            em.close();
        }
    }

    public Long contarLibros() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT COUNT(l) FROM Libro l", Long.class).getSingleResult();
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}
