package com.ejercicio.registro.usuarios.repository;

import com.ejercicio.registro.usuarios.entity.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UsersRepository extends R2dbcRepository<User, UUID> {
    Mono<Boolean> existsByEmail(String email);
}
