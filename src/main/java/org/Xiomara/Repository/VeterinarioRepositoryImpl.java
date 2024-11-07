package org.Xiomara.Repository;

import org.Xiomara.Domain.Veterinario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class VeterinarioRepositoryImpl implements VeterinarioRepository{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("veterinariaPU");

    @Override
    public void guardar(Veterinario veterinario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (veterinario.getId() == null) {
                em.persist(veterinario);  // Guardar un nuevo veterinario
            } else {
                em.merge(veterinario);    // Actualizar un veterinario existente
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Veterinario buscarPorId(String id) {EntityManager em = emf.createEntityManager();
        try {
            return em.find(Veterinario.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Veterinario> buscarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT v FROM Veterinario v", Veterinario.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        try { em.getTransaction().begin();
            Veterinario veterinario = em.find(Veterinario.class, id);
            if (veterinario != null) {
                em.remove(veterinario);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
