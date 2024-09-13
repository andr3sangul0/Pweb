package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Vuelo;
import com.example.miproyectoreserva.repositorios.VueloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloServicio {

    @Autowired
    private VueloRepositorio vueloRepositorio;

    public List<Vuelo> obtenerTodosLosVuelos() {
        return vueloRepositorio.findAll();
    }

    public Vuelo guardarVuelo(Vuelo vuelo) {
        return vueloRepositorio.save(vuelo);
    }

    public void eliminarVuelo(Long id) {
        vueloRepositorio.deleteById(id);
    }
}

