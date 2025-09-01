package com.ejercicio.registro.usuarios.controller;


import com.ejercicio.registro.usuarios.dto.UserRequest;
import com.ejercicio.registro.usuarios.dto.UserResponse;
import com.ejercicio.registro.usuarios.service.UsersService;
import com.ejercicio.registro.usuarios.service.ValidationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    private final ValidationService validationService;

    @PostMapping("/users")
    public Mono<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        validationService.validate(userRequest);
        return usersService.createUser(userRequest);
    }
}
