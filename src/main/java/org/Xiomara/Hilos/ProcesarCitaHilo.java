package org.Xiomara.Hilos;

import org.Xiomara.Modelclasesprin.Cita;

public class ProcesarCitaHilo extends Thread {

    private final Cita cita;

    public ProcesarCitaHilo(Cita cita) {
        this.cita = cita;
    }

    @Override
    public void run() {
        try {
            System.out.println("Procesando cita para la fecha: " + cita.getFecha());
            Thread.sleep(2000); // Simula un tiempo de procesamiento
            System.out.println("Cita procesada para la fecha: " + cita.getFecha());
        } catch (InterruptedException e) {
            System.out.println("Error al procesar la cita: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
