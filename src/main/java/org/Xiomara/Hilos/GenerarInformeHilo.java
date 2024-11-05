package org.Xiomara.Hilos;

import org.Xiomara.service.ClienteService;
import org.Xiomara.service.MascotaService;

public class GenerarInformeHilo extends Thread {

    private final ClienteService clienteService;
    private final MascotaService mascotaService;

    public GenerarInformeHilo(ClienteService clienteService, MascotaService mascotaService) {
        this.clienteService = clienteService;
        this.mascotaService = mascotaService;
    }

    @Override
    public void run() {
        try {
            System.out.println("Generando informe de clientes y mascotas...");
            Thread.sleep(3000); // Simula el tiempo de generación del informe

            System.out.println("\n--- Informe de Clientes ---");
            clienteService.listarClientes().forEach(System.out::println);

            System.out.println("\n--- Informe de Mascotas ---");
            mascotaService.listarMascotas().forEach(System.out::println);

            System.out.println("Informe generado correctamente.");
        } catch (InterruptedException e) {
            System.out.println("Error al generar el informe: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
