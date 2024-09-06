package com.example.miproyectoreserva.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate fechaReserva;
    private int numeroPasajeros;

    @OneToMany(mappedBy = "reserva")
    private List<Pasajero> pasajeros;

    @ManyToMany
    @JoinTable(
            name = "reservaVuelos",
            joinColumns = @JoinColumn( name = "reserva_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "vuelo_id", referencedColumnName = "id")
    )
    private List<Vuelo> vuelos = new ArrayList<>();

    public void addVuelo(Vuelo vuelo){
        this.vuelos.add(vuelo);
    }

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
