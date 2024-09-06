package com.example.miproyectoreserva.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private Long telefono;
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;
}
