package org.Xiomara.Repository;

import org.Xiomara.Domain.Cita;

import java.util.List;

public interface CitaRepository {
    void guardar(Cita cita);               // Crear o actualizar una cita
    Cita buscarPorId(String id);             // Leer una cita por ID
    List<Cita> buscarTodas();              // Leer todas las citas
    void eliminar(Long id);                // Eliminar una cita por ID
}
