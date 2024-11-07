package org.Xiomara.Repository;

import org.Xiomara.Domain.Mascota;

import java.util.List;

public interface MascotaRepository {
    void guardar(Mascota mascota);               // Crear o actualizar una mascota
    Mascota buscarPorId(String id);                // Leer una mascota por ID
    List<Mascota> buscarTodas();                 // Leer todas las mascotas
    void eliminar(Long id);                      // Eliminar una mascota por ID
}
