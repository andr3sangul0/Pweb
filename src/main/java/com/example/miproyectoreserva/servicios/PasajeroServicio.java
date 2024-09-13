package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Pasajero;
import com.example.miproyectoreserva.repositorios.PasajeroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroServicio {

    @Autowired
    private PasajeroRepositorio pasajeroRepositorio;

    public List<Pasajero> obtenerTodosLosPasajeros() {
        return pasajeroRepositorio.findAll();
    }

    public Pasajero guardarPasajero(Pasajero pasajero) {
        return pasajeroRepositorio.save(pasajero);
    }

    public void eliminarPasajero(Long id) {
        pasajeroRepositorio.deleteById(id);
    }
}

