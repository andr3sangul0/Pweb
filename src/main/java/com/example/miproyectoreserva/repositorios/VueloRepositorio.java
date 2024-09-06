package com.example.miproyectoreserva.repositorios;

import com.example.miproyectoreserva.entidades.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepositorio extends JpaRepository<Vuelo, Long> {
}
