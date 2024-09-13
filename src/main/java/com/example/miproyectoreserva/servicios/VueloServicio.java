package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Vuelo;
import com.example.miproyectoreserva.repositorios.VueloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloServicio implements IVueloServicio {

    @Autowired
    private VueloRepositorio vueloRepositorio;
    VueloServicio(VueloRepositorio vueloRepositorio) {
        this.vueloRepositorio = vueloRepositorio;
    }

    @Override
    public List<Vuelo> obtenerTodosLosVuelos() {
        return vueloRepositorio.findAll();
    }

    @Override
    public Vuelo guardarVuelo(Vuelo vuelo) {
        return vueloRepositorio.save(vuelo);
    }

    @Override
    public void eliminarVuelo(Long id) {
        vueloRepositorio.deleteById(id);
    }

    @Override
    public Optional<Vuelo> actualizarVuelo(Long id, Vuelo vuelo) {
        return vueloRepositorio.findById(id).map(oldVuelo -> {
            oldVuelo.setCapacidad(vuelo.getCapacidad());
            oldVuelo.setAerolinea(vuelo.getAerolinea());
            oldVuelo.setDestino(vuelo.getDestino());
            oldVuelo.setDuracion(vuelo.getDuracion());
            oldVuelo.setFechaSalida(vuelo.getFechaSalida());
            oldVuelo.setHoraSalida(vuelo.getHoraSalida());
            oldVuelo.setOrigen(vuelo.getOrigen());
            return vueloRepositorio.save(oldVuelo);
        });
    }
}

