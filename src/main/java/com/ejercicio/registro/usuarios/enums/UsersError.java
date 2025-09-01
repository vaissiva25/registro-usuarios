package com.ejercicio.registro.usuarios.enums;

import org.springframework.http.HttpStatus;

public enum UsersError {
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "Correo ya registrado"),
    ERROR_CREATING_USER(HttpStatus.CONFLICT, "Error al crear el usuario"),
    INVALID_EMAIL(HttpStatus.BAD_REQUEST, "Correo no valido"),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "Request no valido");

    private final HttpStatus status;
    private final String message;

    UsersError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() { return status; }
    public int getStatusCode() { return status.value(); }
    public String getMessage() { return message; }
}
