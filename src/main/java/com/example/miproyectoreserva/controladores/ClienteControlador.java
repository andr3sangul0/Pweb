package com.example.miproyectoreserva.controladores;

import com.example.miproyectoreserva.entidades.Cliente;
import com.example.miproyectoreserva.servicios.ClienteServicio;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    private final ClienteServicio clienteServicio;

    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteServicio.obtenerTodosLosClientes());
    }

    @GetMapping("/id")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        return clienteServicio.obtenerClientePorId(id)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return crearNuevoCliente(cliente);
    }

    private ResponseEntity<Cliente> crearNuevoCliente(Cliente cliente) {
        Cliente clienteNuevo = clienteServicio.guardarCliente(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteNuevo.getId())
                .toUri();
        return ResponseEntity.created(location).body(clienteNuevo);
    }

    @PutMapping("/id")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteNuevo) {
        Optional<Cliente> clienteActualizado = clienteServicio.actualizarCliente(id, clienteNuevo);
        return clienteActualizado.map(cliente -> ResponseEntity.ok(cliente))
                .orElseGet(() -> {
                    return crearNuevoCliente(clienteNuevo);
                });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }


}
