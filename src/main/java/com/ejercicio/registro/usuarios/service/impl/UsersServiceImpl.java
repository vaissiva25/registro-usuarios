package com.ejercicio.registro.usuarios.service.impl;

import com.ejercicio.registro.usuarios.dto.PhoneRequest;
import com.ejercicio.registro.usuarios.dto.UserRequest;
import com.ejercicio.registro.usuarios.dto.UserResponse;
import com.ejercicio.registro.usuarios.entity.Phone;
import com.ejercicio.registro.usuarios.entity.User;
import com.ejercicio.registro.usuarios.enums.UsersError;
import com.ejercicio.registro.usuarios.exception.GenericException;
import com.ejercicio.registro.usuarios.repository.PhonesRepository;
import com.ejercicio.registro.usuarios.repository.UsersRepository;
import com.ejercicio.registro.usuarios.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PhonesRepository phonesRepository;

    @Override
    public Mono<UserResponse> createUser(UserRequest userRequest) {
        return usersRepository.existsByEmail(userRequest.getEmail())
                .flatMap(exits -> {
                    if (exits) {
                        return Mono.error(new GenericException(UsersError.EMAIL_ALREADY_EXISTS));
                    }
                    var user = this.getUser(userRequest);
                    return usersRepository.save(user)
                            .flatMap(saved ->
                                    Flux.fromIterable(userRequest.getPhones())
                                            .map(pr -> getPhone(pr, saved.getId()))
                                            .flatMap(phonesRepository::save)
                                            .then(getResponse(saved))
                            );
                })
                .onErrorResume(throwable -> {
                    System.out.println(throwable.getMessage());
                    return Mono.error(new GenericException(UsersError.ERROR_CREATING_USER));
                });
    }

    private User getUser(UserRequest userRequest) {
        var user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setName(userRequest.getName());
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setToken(createToken());
        user.setActive(true);
        user.setLastLogin(LocalDateTime.now());
        return user;
    }

    private Phone getPhone(PhoneRequest phoneRequest, UUID userId) {
        var phone = new Phone();
        phone.setId(UUID.randomUUID());
        phone.setNumber(phoneRequest.getNumber());
        phone.setCityCode(phoneRequest.getCityCode());
        phone.setCountryCode(phoneRequest.getCountryCode());
        phone.setUserId(userId);
        return phone;
    }

    private Mono<UserResponse> getResponse(User user) {
        return Mono.just(UserResponse.builder()
                .id(user.getId())
                .created(user.getCreated())
                .modified(user.getModified())
                .lastLogin(user.getLastLogin())
                .token(user.getToken())
                .isActive(user.isActive())
                .build());
    }

    private String createToken() {
        return UUID.randomUUID().toString();
    }
}
