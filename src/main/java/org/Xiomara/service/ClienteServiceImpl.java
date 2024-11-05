package org.Xiomara.service;

import org.Xiomara.Modelclasesprin.Cliente;
import org.Xiomara.repository.ClienteRepository;
import java.util.Optional;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente); // Utilizamos save() para actualizar
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
