package org.Xiomara.service;

import org.Xiomara.Modelclasesprin.Cliente;
import java.util.Optional;
import java.util.List;

public interface ClienteService {

    void agregarCliente(Cliente cliente);
    Optional<Cliente> buscarClientePorId(Long id);
    List<Cliente> listarClientes();
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(Long id);

}

