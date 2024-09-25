package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteServicio {
    List<Cliente> obtenerTodosLosClientes();
    Cliente guardarCliente(Cliente cliente);
    void eliminarCliente(Long id);
    Optional<Cliente> obtenerClientePorId(Long id);
    Optional<Cliente> actualizarCliente(Long id, Cliente cliente);
}
