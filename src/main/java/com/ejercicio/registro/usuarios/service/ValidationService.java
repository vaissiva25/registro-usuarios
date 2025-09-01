package com.ejercicio.registro.usuarios.service;

import com.ejercicio.registro.usuarios.dto.UserRequest;

public interface ValidationService {
    void validate(UserRequest userRequest);
}
