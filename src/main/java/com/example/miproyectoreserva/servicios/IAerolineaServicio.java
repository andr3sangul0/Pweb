package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Aerolinea;

import java.util.List;
import java.util.Optional;

public interface IAerolineaServicio {

    List<Aerolinea> obtenerTodasLasAerolineas();
    Aerolinea guardarAerolinea(Aerolinea aerolinea);
    void eliminarAerolinea(Long id);
    Optional<Aerolinea> obtenerAerolineaPorId(Long id);
    Optional<Aerolinea> actualizarAerolinea(Long id, Aerolinea aerolinea);
}
