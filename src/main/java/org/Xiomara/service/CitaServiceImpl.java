package org.Xiomara.service;

import org.Xiomara.Modelclasesprin.Cita;
import org.Xiomara.repository.CitaRepository;

import java.util.List;
import java.util.Optional;
public class CitaServiceImpl implements CitaService{
    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public void agregarCita(Cita cita) {
        citaRepository.save(cita);
    }

    @Override
    public Optional<Cita> buscarCitaPorId(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @Override
    public void actualizarCita(Cita cita) {
        citaRepository.save(cita); //  funciona para actualizar si la cita ya existe
    }

    @Override
    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }
}
