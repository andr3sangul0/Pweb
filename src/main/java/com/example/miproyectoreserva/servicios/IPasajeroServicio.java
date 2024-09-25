package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Pasajero;

import java.util.List;
import java.util.Optional;

public interface IPasajeroServicio {
    List<Pasajero> obtenerTodosLosPasajeros();
    Pasajero guardarPasajero(Pasajero pasajero);
    void eliminarPasajero(Long id);
    Optional<Pasajero> obtenerPasajeroPorId(Long id);
    Optional<Pasajero> actualizarPasajero(Long id,Pasajero pasajero);
}
