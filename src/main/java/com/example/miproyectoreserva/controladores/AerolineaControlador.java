package com.example.miproyectoreserva.controladores;

import com.example.miproyectoreserva.entidades.Aerolinea;
import com.example.miproyectoreserva.entidades.Cliente;
import com.example.miproyectoreserva.servicios.AerolineaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aerolineas")
public class AerolineaControlador {

    private final AerolineaServicio aerolineaServicio;

    public AerolineaControlador(AerolineaServicio aerolineaServicio) {
        this.aerolineaServicio = aerolineaServicio;
    }

    @GetMapping
    public ResponseEntity<List<Aerolinea>> listarAerolineas() {
        return ResponseEntity.ok(aerolineaServicio.obtenerTodasLasAerolineas());
    }

    @GetMapping("/id")
    public ResponseEntity<Aerolinea> obtenerAerolineaPorId(@PathVariable Long id) {
     return aerolineaServicio.obtenerAerolineaPorId(id)
             .map(aerolinea -> ResponseEntity.ok().body(aerolinea))
             .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aerolinea> crearAerolinea(@RequestBody Aerolinea aerolinea) {
        return crearNuevaAerolinea(aerolinea);
    }

    private ResponseEntity<Aerolinea> crearNuevaAerolinea(Aerolinea aerolinea) {
        Aerolinea aerolineaNueva = aerolineaServicio.guardarAerolinea(aerolinea);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(aerolineaNueva.getId())
                .toUri();
        return ResponseEntity.created(location).body(aerolineaNueva);
    }

    @PutMapping("/id")
    public ResponseEntity<Aerolinea> actualizarAerolinea(@PathVariable Long id, @RequestBody Aerolinea aerolineaNueva) {
        Optional<Aerolinea> aerolineaActualizada = aerolineaServicio.actualizarAerolinea(id, aerolineaNueva);
        return aerolineaActualizada.map(aerolinea -> ResponseEntity.ok(aerolinea))
                .orElseGet(() -> {
                    return crearNuevaAerolinea(aerolineaNueva);
                });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Aerolinea> eliminarAerolinea(@PathVariable Long id) {
        aerolineaServicio.eliminarAerolinea(id);
        return ResponseEntity.noContent().build();
    }

}
