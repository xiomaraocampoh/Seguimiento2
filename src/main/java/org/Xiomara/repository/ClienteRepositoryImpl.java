package org.Xiomara.repository;

import org.Xiomara.Modelclasesprin.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
public class ClienteRepositoryImpl implements ClienteRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        return Optional.ofNullable(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

}
