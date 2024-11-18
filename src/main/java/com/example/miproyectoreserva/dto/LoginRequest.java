package com.example.miproyectoreserva.dto;

import lombok.Data;


public record LoginRequest (
        String username,
        String password){

}
