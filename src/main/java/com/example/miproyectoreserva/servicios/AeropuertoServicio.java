package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Aeropuerto;
import com.example.miproyectoreserva.repositorios.AeropuertoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeropuertoServicio {

    @Autowired
    private AeropuertoRepositorio aeropuertoRepositorio;

    public List<Aeropuerto> obtenerTodosLosAeropuertos() {
        return aeropuertoRepositorio.findAll();
    }

    public Aeropuerto guardarAeropuerto(Aeropuerto aeropuerto) {
        return aeropuertoRepositorio.save(aeropuerto);
    }

    public void eliminarAeropuerto(Long id) {
        aeropuertoRepositorio.deleteById(id);
    }
}

