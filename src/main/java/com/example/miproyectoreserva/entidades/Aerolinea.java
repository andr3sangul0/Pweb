package com.example.miproyectoreserva.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "aerolineas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String codigoAerolinea;
    private String paisOrigen;

    @OneToMany(mappedBy = "aerolinea")
    private List<Vuelo> vuelos;
}
