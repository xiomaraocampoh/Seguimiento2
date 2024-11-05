package org.Xiomara.repository;


import org.Xiomara.Modelclasesprin.Cita;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class CitaRepositoryImpl implements CitaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Cita save(Cita cita) {
        entityManager.persist(cita);
        return cita;
    }

    @Override
    public Optional<Cita> findById(Long id) {
        Cita cita = entityManager.find(Cita.class, id);
        return Optional.ofNullable(cita);
    }

    @Override
    public List<Cita> findAll() {
        return entityManager.createQuery("SELECT c FROM Cita c", Cita.class).getResultList();
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Cita cita = entityManager.find(Cita.class, id);
        if (cita != null) {
            entityManager.remove(cita);
        }
    }
}



