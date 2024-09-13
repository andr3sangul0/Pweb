package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Reserva;
import com.example.miproyectoreserva.repositorios.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServicio {

    @Autowired
    private ReservaRepositorio reservaRepositorio;

    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepositorio.findAll();
    }

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepositorio.save(reserva);
    }

    public void eliminarReserva(Long id) {
        reservaRepositorio.deleteById(id);
    }
}

