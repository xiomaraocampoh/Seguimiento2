package org.Xiomara.repository;

import org.Xiomara.Modelclasesprin.Mascota;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class MascotaRepositoryImpl implements MascotaRepository {

@PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Mascota save(Mascota mascota) {
        entityManager.persist(mascota);
        return mascota;
    }

    @Override
    public Optional<Mascota> findById(Long id) {
        Mascota mascota = entityManager.find(Mascota.class, id);
        return Optional.ofNullable(mascota);
    }

    @Override
    public List<Mascota> findAll() {
        return entityManager.createQuery("SELECT m FROM Mascota m", Mascota.class).getResultList();
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Mascota mascota = entityManager.find(Mascota.class, id);
        if (mascota != null) {
            entityManager.remove(mascota);
        }
    }
}

