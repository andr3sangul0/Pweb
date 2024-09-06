package com.example.miproyectoreserva.repositorios;

import com.example.miproyectoreserva.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {
}
