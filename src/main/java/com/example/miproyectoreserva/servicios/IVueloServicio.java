package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Vuelo;

import java.util.List;
import java.util.Optional;

public interface IVueloServicio {
    List<Vuelo> obtenerTodosLosVuelos();
    Vuelo guardarVuelo(Vuelo vuelo);
    void eliminarVuelo(Long id);
    Optional<Vuelo> obtenerVueloPorId(Long id);
    Optional<Vuelo> actualizarVuelo(Long id, Vuelo vuelo);
}
