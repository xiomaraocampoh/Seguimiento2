package org.Xiomara.Main;

import org.Xiomara.Menu.Menuveterinaria;
import org.Xiomara.repository.*;
import org.Xiomara.service.*;

public class Main {
    public static void main(String[] args) {
        // Inicialización de los repositorios
        ClienteRepository clienteRepository = new ClienteRepositoryImpl();
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        CitaRepository citaRepository = new CitaRepositoryImpl();

        // Inicialización de los servicios
        ClienteService clienteService = new ClienteServiceImpl(clienteRepository);
        MascotaService mascotaService = new MascotaServiceImpl(mascotaRepository);
        CitaService citaService = new CitaServiceImpl(citaRepository);

        // Creación del menú principal
    Menuveterinaria menuVeterinaria = new Menuveterinaria(clienteService,mascotaService,citaService );
        // Ejecución del menú
        menuVeterinaria.mostrarMenu();


    }
}
