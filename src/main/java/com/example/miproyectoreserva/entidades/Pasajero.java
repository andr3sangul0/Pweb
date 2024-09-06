package com.example.miproyectoreserva.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pasajeros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private Long cedula;
    private String correoElectronico;
    private String direccion;
    private Long telefono;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

}
