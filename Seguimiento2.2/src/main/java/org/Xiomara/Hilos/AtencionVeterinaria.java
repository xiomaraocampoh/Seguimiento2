package org.Xiomara.Hilos;

import org.Xiomara.Domain.Cita;
import org.Xiomara.Domain.Veterinario;

public class AtencionVeterinaria implements Runnable{
    private Cita cita;              // Cita a ser atendida
    private Veterinario veterinario;  // Veterinario que atenderá la cita

    // Constructor

    public AtencionVeterinaria(Cita cita, Veterinario veterinario) {
        this.cita = cita;
        this.veterinario = veterinario;
    }

    @Override
    public void run() {
        try {
            // Simula el tiempo de atención (por ejemplo, 5 segundos)
            System.out.println("Atención iniciada para la mascota " + cita.getMascota().getNombre() +
                    " por el veterinario " + veterinario.getNombre());
            Thread.sleep(5000);  // Simula que la atención tarda 5 segundos
            System.out.println("Atención completada para la mascota " + cita.getMascota().getNombre() +
                    " por el veterinario " + veterinario.getNombre());
        } catch (InterruptedException e) {
            System.out.println("El proceso de atención fue interrumpido.");
            e.printStackTrace();
        }
    }
}
