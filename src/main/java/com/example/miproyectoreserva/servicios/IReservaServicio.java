package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Reserva;

import java.util.List;
import java.util.Optional;

public interface IReservaServicio {
    List<Reserva> obtenerTodasLasReservas();
    Reserva guardarReserva(Reserva reserva);
    void eliminarReserva(Long id);
    Optional<Reserva> buscarReservaPorId(Long id);
    Optional<Reserva> actualizarReserva(Long id, Reserva reserva);
}
