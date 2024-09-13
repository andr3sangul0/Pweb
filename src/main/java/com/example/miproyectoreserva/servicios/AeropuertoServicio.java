package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Aeropuerto;
import com.example.miproyectoreserva.repositorios.AeropuertoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeropuertoServicio implements IAeropuertoServicio{

    @Autowired
    private AeropuertoRepositorio aeropuertoRepositorio;
    AeropuertoServicio(AeropuertoRepositorio aeropuertoRepositorio) {
        this.aeropuertoRepositorio = aeropuertoRepositorio;
    };

    @Override
    public List<Aeropuerto> obtenerTodosLosAeropuertos() {
        return aeropuertoRepositorio.findAll();
    }

    @Override
    public Aeropuerto guardarAeropuerto(Aeropuerto aeropuerto) {
        return aeropuertoRepositorio.save(aeropuerto);
    }

    @Override
    public void eliminarAeropuerto(Long id) {
        aeropuertoRepositorio.deleteById(id);
    }

    @Override
    public Optional<Aeropuerto> actualizarAeropuerto(Long id, Aeropuerto aeropuerto) {
        return aeropuertoRepositorio.findById(id).map(oldAeropuerto -> {
            oldAeropuerto.setNombre(aeropuerto.getNombre());
            oldAeropuerto.setCiudad(aeropuerto.getCiudad());
            oldAeropuerto.setPais(aeropuerto.getPais());
            return aeropuertoRepositorio.save(oldAeropuerto);
        });
    }
}

