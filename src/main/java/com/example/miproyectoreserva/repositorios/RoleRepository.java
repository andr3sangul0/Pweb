package com.example.miproyectoreserva.repositorios;

import com.example.miproyectoreserva.entidades.ERole;
import com.example.miproyectoreserva.entidades.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}