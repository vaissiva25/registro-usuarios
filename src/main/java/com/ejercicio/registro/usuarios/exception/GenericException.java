package com.ejercicio.registro.usuarios.exception;

import com.ejercicio.registro.usuarios.enums.UsersError;

public class GenericException extends RuntimeException {
    private final UsersError error;

    public GenericException(UsersError error) {
        super(error.getMessage());
        this.error = error;
    }

    public UsersError getError() {
        return error;
    }

    public int getStatusCode() {
        return error.getStatusCode();
    }

    public String getErrorMessage() {
        return error.getMessage();
    }
}
