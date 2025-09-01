package com.ejercicio.registro.usuarios.config.web;

import com.ejercicio.registro.usuarios.dto.ErrorResponse;
import com.ejercicio.registro.usuarios.exception.GenericException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class UsersControllerAdvice {
    @ExceptionHandler(GenericException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleGenericException(GenericException ex) {
        return Mono.just(ResponseEntity
                .status(ex.getStatusCode())
                .body(new ErrorResponse(ex.getErrorMessage())));
    }
}
