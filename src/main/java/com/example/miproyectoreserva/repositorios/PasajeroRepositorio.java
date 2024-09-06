package com.example.miproyectoreserva.repositorios;

import com.example.miproyectoreserva.entidades.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepositorio extends JpaRepository<Pasajero, Long> {
}
