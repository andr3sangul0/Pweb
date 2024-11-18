package com.example.miproyectoreserva.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record VueloDto(Long id,
                       LocalDate fechaSalida,
                       LocalTime horaSalida,
                       Integer duracion,
                       Integer capacidad) {
}
