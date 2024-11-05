package org.Xiomara.service;

import org.Xiomara.Modelclasesprin.Cita;
import java.util.Optional;
import java.util.List;

public interface CitaService {

    void agregarCita(Cita cita);
    Optional<Cita> buscarCitaPorId(Long id);
    List<Cita> listarCitas();
    void actualizarCita(Cita cita);
    void eliminarCita(Long id);

}
