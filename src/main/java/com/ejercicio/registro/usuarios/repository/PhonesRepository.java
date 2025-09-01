package com.ejercicio.registro.usuarios.repository;

import com.ejercicio.registro.usuarios.entity.Phone;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.util.UUID;

public interface PhonesRepository  extends R2dbcRepository<Phone, UUID> {
}
