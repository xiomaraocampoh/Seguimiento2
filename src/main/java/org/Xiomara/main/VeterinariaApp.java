package org.Xiomara.main;

import org.Xiomara.Domain.Cita;
import org.Xiomara.Domain.Mascota;
import org.Xiomara.Domain.Veterinario;
import org.Xiomara.Enums.EstadoSalud;
import org.Xiomara.Enums.TipoAnimal;
import org.Xiomara.Hilos.AtencionVeterinaria;
import org.Xiomara.Repository.*;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class VeterinariaApp {
    private static final MascotaRepository mascotaRepository = new MascotaRepositoryImp();
    private static final CitaRepository citaRepository = new CitaRepositoryImpl();
    private static final VeterinarioRepository veterinarioRepository = new VeterinarioRepositoryImpl();

    public static void main(String[] args) {
        // Crear un veterinario predeterminado
        Veterinario veterinario1 = new Veterinario("Dr. Juan", "Cirugía", "123-456-789");
        veterinarioRepository.guardar(veterinario1);

        while (true) {
            String[] options = {"Registrar una nueva mascota", "Registrar una nueva cita", "Ver todas las citas", "Atender una cita", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú de Veterinaria",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (opcion) {
                case 0:
                    registrarMascota();
                    break;
                case 1:
                    registrarCita();
                    break;
                case 2:
                    verCitas();
                    break;
                case 3:
                    atenderCitas();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema de veterinaria!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intenta de nuevo.");
            }
        }
    }

    private static void registrarMascota() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");

        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de animal (PERRO, GATO, etc.):").toUpperCase();
        TipoAnimal tipoAnimal = TipoAnimal.valueOf(tipo);

        String estado = JOptionPane.showInputDialog("Ingrese el estado de salud de la mascota (SANO, ENFERMO, etc.):").toUpperCase();
        EstadoSalud estadoSalud = EstadoSalud.valueOf(estado);

        Mascota mascota = new Mascota(nombre, tipoAnimal, estadoSalud);
        mascotaRepository.guardar(mascota);
        JOptionPane.showMessageDialog(null, "Mascota registrada exitosamente: " + mascota.getNombre());
    }

    private static void registrarCita() {
        String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota para la cita:");
        Mascota mascota = mascotaRepository.buscarPorId(nombreMascota);

        if (mascota == null) {
            JOptionPane.showMessageDialog(null, "Mascota no encontrada. Asegúrese de registrarla primero.");
            return;
        }

        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la cita:");
        Veterinario veterinario = veterinarioRepository.buscarPorId("Dr. Juan");

        Cita cita = new Cita(mascota, new java.util.Date(), descripcion, veterinario);
        citaRepository.guardar(cita);
        JOptionPane.showMessageDialog(null, "Cita registrada para la mascota " + mascota.getNombre());
    }

    private static void verCitas() {
        List<Cita> citas = citaRepository.buscarTodas();
        StringBuilder citasInfo = new StringBuilder("***** Lista de Citas Registradas *****\n");

        for (Cita cita : citas) {
            citasInfo.append("Mascota: ").append(cita.getMascota().getNombre())
                    .append(", Veterinario: ").append(cita.getVeterinario().getNombre())
                    .append(", Descripción: ").append(cita.getMotivo())
                    .append(", Fecha: ").append(cita.getFecha())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, citasInfo.toString());
    }

    private static void atenderCitas() {
        String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota para atender la cita:");
        Cita cita = citaRepository.buscarPorId(nombreMascota);

        if (cita == null) {
            JOptionPane.showMessageDialog(null, "No se encontró una cita para esta mascota.");
            return;
        }

        Veterinario veterinario = veterinarioRepository.buscarPorId("Dr. Juan");

        // Crear un hilo para la atención de esta cita
        Thread hilo = new Thread(new AtencionVeterinaria(cita, veterinario));
        hilo.start();  // Comienza el proceso de atención en un hilo nuevo

        try {
            hilo.join();  // Espera a que el hilo termine antes de continuar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "La cita para " + cita.getMascota().getNombre() + " ha sido atendida.");
    }
}