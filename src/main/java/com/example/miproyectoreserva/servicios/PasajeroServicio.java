package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Pasajero;
import com.example.miproyectoreserva.repositorios.PasajeroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroServicio implements IPasajeroServicio{

    @Autowired
    private PasajeroRepositorio pasajeroRepositorio;
    PasajeroServicio(PasajeroRepositorio pasajeroRepositorio) {
        this.pasajeroRepositorio = pasajeroRepositorio;
    };

    @Override
    public List<Pasajero> obtenerTodosLosPasajeros() {
        return pasajeroRepositorio.findAll();
    }

    @Override
    public Pasajero guardarPasajero(Pasajero pasajero) {
        return pasajeroRepositorio.save(pasajero);
    }

    @Override
    public void eliminarPasajero(Long id) {
        pasajeroRepositorio.deleteById(id);
    }

    @Override
    public Optional<Pasajero> obtenerPasajeroPorId(Long id) {
        return pasajeroRepositorio.findById(id);
    }

    @Override
    public Optional<Pasajero> actualizarPasajero(Long id, Pasajero pasajero) {
        return pasajeroRepositorio.findById(id).map(oldPasajero -> {
            oldPasajero.setNombre(pasajero.getNombre());
            oldPasajero.setApellido(pasajero.getApellido());
            oldPasajero.setCedula(pasajero.getCedula());
            oldPasajero.setDireccion(pasajero.getDireccion());
            oldPasajero.setCorreoElectronico(pasajero.getCorreoElectronico());
            oldPasajero.setReserva(pasajero.getReserva());
            oldPasajero.setTelefono(pasajero.getTelefono());
            return pasajeroRepositorio.save(oldPasajero);
        });
    }


}

