package com.example.miproyectoreserva.controladores;

import com.example.miproyectoreserva.entidades.Vuelo;
import com.example.miproyectoreserva.servicios.VueloServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vuelos")
public class VueloControlador {

    private final VueloServicio vueloServicio;

    public VueloControlador(VueloServicio vueloServicio) {
        this.vueloServicio = vueloServicio;
    }

    @GetMapping
    public ResponseEntity<List<Vuelo>> listarVuelos() {
        return ResponseEntity.ok(vueloServicio.obtenerTodosLosVuelos());
    }

    @GetMapping
    public ResponseEntity<Vuelo> obtenerVueloPorId(@PathVariable Long id) {
        return vueloServicio.obtenerVueloPorId(id)
                .map(vuelo -> ResponseEntity.ok().body(vuelo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vuelo> crearVuelo(@RequestBody Vuelo vuelo) {
        return crearNuevoVuelo(vuelo);
    }

    private ResponseEntity<Vuelo> crearNuevoVuelo(Vuelo vuelo) {
        Vuelo nuevoVuelo = vueloServicio.guardarVuelo(vuelo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nuevoVuelo.getId())
                .toUri();
        return ResponseEntity.created(location).body(nuevoVuelo);
    }

    @PutMapping("/id")
    public ResponseEntity<Vuelo> actualizarVuelo(@PathVariable Long id, @RequestBody Vuelo vueloNuevo) {
        Optional<Vuelo> vueloActualizado = vueloServicio.actualizarVuelo(id, vueloNuevo);
        return vueloActualizado.map(vuelo -> ResponseEntity.ok(vuelo)).orElseGet(() -> {
            return crearNuevoVuelo(vueloNuevo);
        });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> eliminarVuelo(@PathVariable Long id) {
        vueloServicio.eliminarVuelo(id);
        return ResponseEntity.noContent().build();
    }
}
