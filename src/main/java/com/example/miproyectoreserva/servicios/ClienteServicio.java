package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Cliente;
import com.example.miproyectoreserva.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepositorio.findAll();
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }
}

