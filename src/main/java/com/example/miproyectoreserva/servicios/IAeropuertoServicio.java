package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Aeropuerto;

import java.util.List;
import java.util.Optional;

public interface IAeropuertoServicio {
    List<Aeropuerto> obtenerTodosLosAeropuertos();
    Aeropuerto guardarAeropuerto(Aeropuerto aeropuerto);
    void eliminarAeropuerto(Long id);
    Optional<Aeropuerto> obtenerAeropuertoPorId(Long id);
    Optional<Aeropuerto> actualizarAeropuerto(Long id, Aeropuerto aeropuerto);
}
