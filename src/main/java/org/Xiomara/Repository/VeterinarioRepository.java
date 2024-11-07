package org.Xiomara.Repository;

import org.Xiomara.Domain.Veterinario;

import java.util.List;

public interface VeterinarioRepository {
    void guardar(Veterinario veterinario);     // Crear o actualizar un veterinario
    Veterinario buscarPorId(String id);          // Leer un veterinario por ID
    List<Veterinario> buscarTodos();           // Leer todos los veterinarios
    void eliminar(Long id);                    // Eliminar un veterinario por ID
}
