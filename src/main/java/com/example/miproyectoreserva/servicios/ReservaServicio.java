package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Reserva;
import com.example.miproyectoreserva.repositorios.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServicio implements IReservaServicio{

    @Autowired
    private ReservaRepositorio reservaRepositorio;
    ReservaServicio(ReservaRepositorio reservaRepositorio) {
        this.reservaRepositorio = reservaRepositorio;
    }

    @Override
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepositorio.findAll();
    }

    @Override
    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepositorio.save(reserva);
    }

    @Override
    public void eliminarReserva(Long id) {
        reservaRepositorio.deleteById(id);
    }

    @Override
    public Optional<Reserva> actualizarReserva(Long id, Reserva reserva) {
        return reservaRepositorio.findById(id).map(oldReserva -> {
            oldReserva.setFechaReserva(reserva.getFechaReserva());
            oldReserva.setNumeroPasajeros(reserva.getNumeroPasajeros());
            return reservaRepositorio.save(oldReserva);
        });
    }
}

