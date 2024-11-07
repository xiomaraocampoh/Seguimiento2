package org.Xiomara.Repository;

import org.Xiomara.Domain.Cita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CitaRepositoryImpl implements CitaRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("veterinariaPU");

    @Override
    public void guardar(Cita cita) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (cita.getId() == null) {
                em.persist(cita);  // Guardar una nueva cita
            } else {
                em.merge(cita);    // Actualizar una cita existente
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Cita buscarPorId(String id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cita.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Cita> buscarTodas() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cita c", Cita.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cita cita = em.find(Cita.class, id);
            if (cita != null) {
                em.remove(cita);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
