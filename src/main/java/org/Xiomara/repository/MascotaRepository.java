package org.Xiomara.repository;

import org.Xiomara.Modelclasesprin.Mascota;
import java.util.List;
import java.util.Optional;

public interface MascotaRepository  {

    Mascota save(Mascota mascota);
    Optional<Mascota> findById(Long id);
    List<Mascota> findAll();
    void deleteById(Long id);

}
