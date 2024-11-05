package org.Xiomara.service;

import org.Xiomara.Modelclasesprin.Mascota;
import java.util.List;
import java.util.Optional;

public interface MascotaService {

    void agregarMascota(Mascota mascota);
    Optional<Mascota> buscarMascotaPorId(Long id);
    List<Mascota> listarMascotas();
    void actualizarMascota(Mascota mascota);
    void eliminarMascota(Long id);

}
