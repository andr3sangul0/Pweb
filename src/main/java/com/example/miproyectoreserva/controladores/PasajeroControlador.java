package com.example.miproyectoreserva.controladores;

import com.example.miproyectoreserva.entidades.Pasajero;
import com.example.miproyectoreserva.servicios.PasajeroServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pasajeros")
public class PasajeroControlador {

    private final PasajeroServicio pasajeroServicio;

    public PasajeroControlador(PasajeroServicio pasajeroServicio) {
        this.pasajeroServicio = pasajeroServicio;
    }

    @GetMapping
    public ResponseEntity<List<Pasajero>> listarPasajeros() {
        return ResponseEntity.ok(pasajeroServicio.obtenerTodosLosPasajeros());
    }

    @GetMapping("/id")
    public ResponseEntity<Pasajero> obtenerPasajeroPorId(@PathVariable Long id) {
        return pasajeroServicio.obtenerPasajeroPorId(id)
                .map(pasajero -> ResponseEntity.ok().body(pasajero))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pasajero> crearPasajero(@RequestBody Pasajero pasajero) {
        return crearNuevoPasajero(pasajero);
    }

    private ResponseEntity<Pasajero> crearNuevoPasajero(Pasajero pasajero) {
        Pasajero pasajeroNuevo = pasajeroServicio.guardarPasajero(pasajero);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pasajeroNuevo.getId())
                .toUri();
        return ResponseEntity.created(location).body(pasajeroNuevo);
    }

    @PutMapping("/id")
    public ResponseEntity<Pasajero> actualizarPasajero(@PathVariable Long id, @RequestBody Pasajero pasajeroNuevo) {
        Optional<Pasajero> pasajeroActualizado = pasajeroServicio.actualizarPasajero(id, pasajeroNuevo);
        return  pasajeroActualizado.map(pasajero -> ResponseEntity.ok(pasajero)).orElseGet(() -> {
            return crearNuevoPasajero(pasajeroNuevo);
        });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Pasajero> eliminarPasajero(@PathVariable Long id) {
        pasajeroServicio.eliminarPasajero(id);
        return ResponseEntity.noContent().build();
    }
}
