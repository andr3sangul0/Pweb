package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Aerolinea;
import com.example.miproyectoreserva.repositorios.AerolineaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerolineaServicio {

    @Autowired
    private AerolineaRepositorio aerolineaRepositorio;

    public List<Aerolinea> obtenerTodasLasAerolineas() {
        return aerolineaRepositorio.findAll();
    }

    public Aerolinea guardarAerolinea(Aerolinea aerolinea) {
        return aerolineaRepositorio.save(aerolinea);
    }

    public void eliminarAerolinea(Long id) {
        aerolineaRepositorio.deleteById(id);
    }
}

