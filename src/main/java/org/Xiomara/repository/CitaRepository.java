package org.Xiomara.repository;

import org.Xiomara.Modelclasesprin.Cita;

import java.util.List;

import java.util.Optional;

public interface CitaRepository {

    Cita save(Cita cita);
    Optional<Cita> findById(Long id);
    List<Cita> findAll();
    void deleteById(Long id);

}
