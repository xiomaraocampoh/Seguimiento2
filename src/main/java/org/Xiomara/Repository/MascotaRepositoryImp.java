package org.Xiomara.Repository;

import org.Xiomara.Domain.Mascota;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MascotaRepositoryImp implements MascotaRepository{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("veterinariaPU");

    @Override
    public void guardar(Mascota mascota) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (mascota.getId() == null) {
                em.persist(mascota);  // Guardar una nueva mascota
            } else {
                em.merge(mascota);    // Actualizar una mascota existente
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Mascota buscarPorId(String id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Mascota.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Mascota> buscarTodas() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT m FROM Mascota m", Mascota.class).getResultList();
        } finally {
            em.close();
        }
    }
    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Mascota mascota = em.find(Mascota.class, id);
            if (mascota != null) {
                em.remove(mascota);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}