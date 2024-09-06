package com.example.miproyectoreserva.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "vuelos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private int duracion;
    private int capacidad;

    @ManyToMany(mappedBy = "vuelos")
    private List<Reserva> reservas;

    @ManyToOne
    @JoinColumn(name = "aerolinea_id")
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "origen_id")
    private Aeropuerto origen;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Aeropuerto destino;
}
