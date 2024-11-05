package org.Xiomara.service;

import org.Xiomara.Modelclasesprin.Mascota;
import org.Xiomara.repository.MascotaRepository;
import java.util.Optional;
import java.util.List;

public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public void agregarMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public Optional<Mascota> buscarMascotaPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public void actualizarMascota(Mascota mascota) {
        mascotaRepository.save(mascota); // `save` actualiza si la mascota ya existe
    }

    @Override
    public void eliminarMascota(Long id) {
        mascotaRepository.deleteById(id);
    }
}