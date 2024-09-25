package com.example.miproyectoreserva.controladores;

import com.example.miproyectoreserva.entidades.Aerolinea;
import com.example.miproyectoreserva.entidades.Aeropuerto;
import com.example.miproyectoreserva.servicios.AeropuertoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aeropuertos")
public class AeropuertoControlador {

    private final AeropuertoServicio aeropuertoServicio;

    public AeropuertoControlador(AeropuertoServicio aeropuertoServicio) {
        this.aeropuertoServicio = aeropuertoServicio;
    }

    @GetMapping
    public ResponseEntity<List<Aeropuerto>> listarAeropuertos() {
        return ResponseEntity.ok(aeropuertoServicio.obtenerTodosLosAeropuertos());
    }

    @GetMapping("/id")
    public ResponseEntity<Aeropuerto> obtenerAeropuertoPorId(@PathVariable Long id) {
        return aeropuertoServicio.obtenerAeropuertoPorId(id)
                .map(aeropuerto -> ResponseEntity.ok().body(aeropuerto))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aeropuerto> crearAeropuerto(@RequestBody Aeropuerto aeropuerto) {
        return crearNuevoAeropuerto(aeropuerto);
    }

    private ResponseEntity<Aeropuerto> crearNuevoAeropuerto(Aeropuerto aeropuerto) {
        Aeropuerto aeropuertoNuevo = aeropuertoServicio.guardarAeropuerto(aeropuerto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(aeropuertoNuevo.getId())
                .toUri();
        return ResponseEntity.created(location).body(aeropuertoNuevo);
    }

    @PutMapping("/id")
    public ResponseEntity<Aeropuerto> actualizarAeropuerto(@PathVariable Long id, @RequestBody Aeropuerto aeropuertoNuevo) {
        Optional<Aeropuerto> aeropuertoActualizado = aeropuertoServicio.actualizarAeropuerto(id, aeropuertoNuevo);
        return aeropuertoActualizado.map(aeropuerto -> ResponseEntity.ok(aeropuerto)).orElseGet(() -> {
            return crearNuevoAeropuerto(aeropuertoNuevo);
        });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Aeropuerto> eliminarAeropuerto(@PathVariable Long id) {
        aeropuertoServicio.eliminarAeropuerto(id);
        return ResponseEntity.noContent().build();
    }
}
