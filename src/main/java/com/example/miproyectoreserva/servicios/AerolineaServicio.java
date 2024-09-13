package com.example.miproyectoreserva.servicios;

import com.example.miproyectoreserva.entidades.Aerolinea;
import com.example.miproyectoreserva.repositorios.AerolineaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AerolineaServicio implements IAerolineaServicio {

    @Autowired
    private AerolineaRepositorio aerolineaRepositorio;
    AerolineaServicio(AerolineaRepositorio aerolineaRepositorio) {
        this.aerolineaRepositorio = aerolineaRepositorio;
    };

    @Override
    public List<Aerolinea> obtenerTodasLasAerolineas() {
        return aerolineaRepositorio.findAll();
    }

    @Override
    public Aerolinea guardarAerolinea(Aerolinea aerolinea) {
        return aerolineaRepositorio.save(aerolinea);
    }

    @Override
    public void eliminarAerolinea(Long id) {
        aerolineaRepositorio.deleteById(id);
    }

    @Override
    public Optional<Aerolinea> actualizarAerolinea(Long id, Aerolinea aerolinea) {
        return aerolineaRepositorio.findById(id).map(oldAerolinea -> {
            oldAerolinea.setCodigoAerolinea(aerolinea.getCodigoAerolinea());
            oldAerolinea.setNombre(aerolinea.getNombre());
            oldAerolinea.setPaisOrigen(aerolinea.getPaisOrigen());
            return aerolineaRepositorio.save(oldAerolinea);
        });
    }
}

