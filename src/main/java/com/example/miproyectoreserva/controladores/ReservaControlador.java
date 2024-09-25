package com.example.miproyectoreserva.controladores;

import com.example.miproyectoreserva.entidades.Reserva;
import com.example.miproyectoreserva.servicios.ReservaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaControlador {

    private final ReservaServicio reservaServicio;

    public ReservaControlador(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas() {
        return ResponseEntity.ok(reservaServicio.obtenerTodasLasReservas());
    }

    @GetMapping("/id")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable Long id) {
        return reservaServicio.buscarReservaPorId(id)
                .map(reserva -> ResponseEntity.ok().body(reserva))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        return crearNuevaReserva(reserva);
    }

    private ResponseEntity<Reserva> crearNuevaReserva(Reserva reserva) {
        Reserva reservaNueva = reservaServicio.guardarReserva(reserva);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reservaNueva.getId())
                .toUri();
        return ResponseEntity.created(location).body(reservaNueva);
    }

    @PutMapping("/id")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @RequestBody Reserva reservaNueva) {
        Optional<Reserva> reservaActualizada = reservaServicio.actualizarReserva(id, reservaNueva);
        return reservaActualizada.map(reserva -> ResponseEntity.ok(reserva)).orElseGet(() -> {
            return crearNuevaReserva(reservaNueva);
        });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Reserva> eliminarReserva(@PathVariable Long id) {
        reservaServicio.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }
}
