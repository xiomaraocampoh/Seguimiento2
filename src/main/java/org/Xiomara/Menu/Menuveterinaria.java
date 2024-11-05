package org.Xiomara.Menu;

import org.Xiomara.Hilos.GenerarInformeHilo;
import org.Xiomara.Hilos.ProcesarCitaHilo;
import org.Xiomara.Modelclasesprin.Cita;
import org.Xiomara.Modelclasesprin.Cliente;
import org.Xiomara.Modelclasesprin.Mascota;
import org.Xiomara.service.CitaService;
import org.Xiomara.service.ClienteService;
import org.Xiomara.service.MascotaService;

import javax.swing.*;

public class Menuveterinaria {

    private final ClienteService clienteService;
    private final MascotaService mascotaService;
    private final CitaService citaService;

public Menuveterinaria(ClienteService clienteService, MascotaService mascotaService, CitaService citaService) {
    this.clienteService = clienteService;
    this.mascotaService = mascotaService;
    this.citaService = citaService;
}

public void mostrarMenu() {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(null,
                    "--- Menú Veterinaria ---\n" +
                            "1. Gestionar Clientes\n" +
                            "2. Gestionar Mascotas\n" +
                            "3. Gestionar Citas\n" +
                            "4. Salir\n" +
                            "Seleccione una opción:");

            if (opcion == null) break; // Si el usuario cierra la ventana

            switch (opcion) {
                case "1":
                    menuClientes();
                    break;
                case "2":
                    menuMascotas();
                    break;
                case "3":
                    menuCitas();
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente de nuevo.");
            }
        } while (!"4".equals(opcion));
    }

    private void menuClientes() {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(null,
                    "--- Gestión de Clientes ---\n" +
                            "1. Agregar Cliente\n" +
                            "2. Buscar Cliente por ID\n" +
                            "3. Listar Clientes\n" +
                            "4. Eliminar Cliente\n" +
                            "5. Volver al Menú Principal\n" +
                            "Seleccione una opción:");

            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    agregarCliente();
                    break;
                case "2":
                    buscarCliente();
                    break;
                case "3":
                    listarClientes();
                    break;
                case "4":
                    eliminarCliente();
                    break;
                case "5":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente de nuevo.");
            }
        } while (!"5".equals(opcion));
    }

    private void menuMascotas() {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(null,
                    "--- Gestión de Mascotas ---\n" +
                            "1. Agregar Mascota\n" +
                            "2. Buscar Mascota por ID\n" +
                            "3. Listar Mascotas\n" +
                            "4. Eliminar Mascota\n" +
                            "5. Volver al Menú Principal\n" +
                            "Seleccione una opción:");

            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    agregarMascota();
                    break;
                case "2":
                    buscarMascota();
                    break;
                case "3":
                    listarMascotas();
                    break;
                case "4":
                    eliminarMascota();
                    break;
                case "5":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente de nuevo.");
            }
        } while (!"5".equals(opcion));
    }

    private void menuCitas() {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(null,
                    "--- Gestión de Citas ---\n" +
                            "1. Agregar Cita\n" +
                            "2. Buscar Cita por ID\n" +
                            "3. Listar Citas\n" +
                            "4. Eliminar Cita\n" +
                            "5. Procesar Cita (con Hilo)\n" +
                            "6. Generar Informe (con Hilo)\n" +
                            "7. Volver al Menú Principal\n" +
                            "Seleccione una opción:");

            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    agregarCita();
                    break;
                case "2":
                    buscarCita();
                    break;
                case "3":
                    listarCitas();
                    break;
                case "4":
                    eliminarCita();
                    break;
                case "5":
                    procesarCitaConHilo();
                    break;
                case "6":
                    generarInformeConHilo();
                    break;
                case "7":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente de nuevo.");
            }
        } while (!"7".equals(opcion));
    }

    // Métodos CRUD usando JOptionPane para entrada y salida
        private void agregarCliente() {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            if (nombre != null) {
                Cliente cliente = new Cliente(nombre);
                clienteService.agregarCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente.");
            }
        }

        private void buscarCliente() {
            String idStr = JOptionPane.showInputDialog("Ingrese el ID del cliente:");
            if (idStr != null) {
                Long id = Long.parseLong(idStr);
                clienteService.buscarClientePorId(id).ifPresentOrElse(
                        cliente -> JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente),
                        () -> JOptionPane.showMessageDialog(null, "Cliente no encontrado.")
                );
            }
        }

        private void listarClientes() {
            StringBuilder sb = new StringBuilder("--- Lista de Clientes ---\n");
            clienteService.listarClientes().forEach(cliente -> sb.append(cliente).append("\n"));
            JOptionPane.showMessageDialog(null, sb.toString());
        }

        private void eliminarCliente() {
            String idStr = JOptionPane.showInputDialog("Ingrese el ID del cliente a eliminar:");
            if (idStr != null) {
                Long id = Long.parseLong(idStr);
                clienteService.eliminarCliente(id);
                JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.");
            }
        }

        // Métodos CRUD para Mascota (agregar, buscar, listar, eliminar)
        private void agregarMascota() {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
            if (nombre != null) {
                Mascota mascota = new Mascota(nombre);
                mascotaService.agregarMascota(mascota);
                JOptionPane.showMessageDialog(null, "Mascota agregada exitosamente.");
            }
        }

        private void buscarMascota() {
            String idStr = JOptionPane.showInputDialog("Ingrese el ID de la mascota:");
            if (idStr != null) {
                Long id = Long.parseLong(idStr);
                mascotaService.buscarMascotaPorId(id).ifPresentOrElse(
                        mascota -> JOptionPane.showMessageDialog(null, "Mascota encontrada: " + mascota),
                        () -> JOptionPane.showMessageDialog(null, "Mascota no encontrada.")
                );
            }
        }

        private void listarMascotas() {
            StringBuilder sb = new StringBuilder("--- Lista de Mascotas ---\n");
            mascotaService.listarMascotas().forEach(mascota -> sb.append(mascota).append("\n"));
            JOptionPane.showMessageDialog(null, sb.toString());
        }

        private void eliminarMascota() {
            String idStr = JOptionPane.showInputDialog("Ingrese el ID de la mascota a eliminar:");
            if (idStr != null) {
                Long id = Long.parseLong(idStr);
                mascotaService.eliminarMascota(id);
                JOptionPane.showMessageDialog(null, "Mascota eliminada exitosamente.");
            }
        }

        // Métodos para Cita (agregar, buscar, listar, eliminar, procesar con hilo, generar informe)
        private void agregarCita() {
            String fecha = JOptionPane.showInputDialog("Ingrese la fecha de la cita (YYYY-MM-DD):");
            if (fecha != null) {
                Cita cita = new Cita(fecha);
                citaService.agregarCita(cita);
                JOptionPane.showMessageDialog(null, "Cita agregada exitosamente.");
            }
        }

        private void buscarCita() {
            String idStr = JOptionPane.showInputDialog("Ingrese el ID de la cita:");
            if (idStr != null) {
                Long id = Long.parseLong(idStr);
                citaService.buscarCitaPorId(id).ifPresentOrElse(
                        cita -> JOptionPane.showMessageDialog(null, "Cita encontrada: " + cita),
                        () -> JOptionPane.showMessageDialog(null, "Cita no encontrada.")
                );
            }
        }

    private void listarCitas() {
        StringBuilder sb = new StringBuilder("--- Lista de Citas ---\n");
        citaService.listarCitas().forEach(cita -> sb.append(cita).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void eliminarCita() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID de la cita a eliminar:");
        if (idStr != null) {
            Long id = Long.parseLong(idStr);
            citaService.eliminarCita(id);
            JOptionPane.showMessageDialog(null, "Cita eliminada exitosamente.");
        }
    }

    private void procesarCitaConHilo() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID de la cita a procesar:");
        if (idStr != null) {
            Long id = Long.parseLong(idStr);
            citaService.buscarCitaPorId(id).ifPresentOrElse(
                    cita -> {
                        ProcesarCitaHilo procesarCitaHilo = new ProcesarCitaHilo(cita);
                        procesarCitaHilo.start();
                        JOptionPane.showMessageDialog(null, "Procesando cita en segundo plano...");
                    },
                    () -> JOptionPane.showMessageDialog(null, "Cita no encontrada.")
            );
        }
    }

    private void generarInformeConHilo() {
        GenerarInformeHilo generarInformeHilo = new GenerarInformeHilo(clienteService, mascotaService);
        generarInformeHilo.start();
        JOptionPane.showMessageDialog(null, "Generando informe en segundo plano...");
    }
}