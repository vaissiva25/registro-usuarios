package com.ejercicio.registro.usuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse implements Serializable {
    private String mensaje;
}
