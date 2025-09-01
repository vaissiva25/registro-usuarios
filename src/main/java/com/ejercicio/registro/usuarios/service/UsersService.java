package com.ejercicio.registro.usuarios.service;

import com.ejercicio.registro.usuarios.dto.UserRequest;
import com.ejercicio.registro.usuarios.dto.UserResponse;
import reactor.core.publisher.Mono;

public interface UsersService {
    Mono<UserResponse> createUser(UserRequest userRequest);
}
