package com.example.miproyectoreserva.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "aeropuertos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String ciudad;
    private String pais;

    @OneToMany(mappedBy = "origen")
    private List<Vuelo> vuelosOrigen;

    @OneToMany(mappedBy = "destino")
    private List<Vuelo> vuelosDestino;
}
