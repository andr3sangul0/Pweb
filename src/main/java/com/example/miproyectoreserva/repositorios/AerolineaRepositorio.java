package com.example.miproyectoreserva.repositorios;

import com.example.miproyectoreserva.entidades.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerolineaRepositorio extends JpaRepository<Aerolinea, Long> {
}
