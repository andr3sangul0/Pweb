package com.example.miproyectoreserva.repositorios;

import com.example.miproyectoreserva.entidades.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertoRepositorio extends JpaRepository<Aeropuerto, Long> {
}
