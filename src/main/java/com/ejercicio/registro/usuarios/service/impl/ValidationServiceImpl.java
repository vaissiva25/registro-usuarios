package com.ejercicio.registro.usuarios.service.impl;

import com.ejercicio.registro.usuarios.dto.UserRequest;
import com.ejercicio.registro.usuarios.enums.UsersError;
import com.ejercicio.registro.usuarios.exception.GenericException;
import com.ejercicio.registro.usuarios.properties.UserProperties;
import com.ejercicio.registro.usuarios.service.ValidationService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidationServiceImpl implements ValidationService {
    private final Pattern emailPattern;
    private final Pattern passwordPattern;

    public ValidationServiceImpl(UserProperties props) {
        this.emailPattern = Pattern.compile(props.getEmailRegex());
        this.passwordPattern = Pattern.compile(props.getPasswordRegex());
    }

    @Override
    public void validate(UserRequest userRequest) {
        if (!emailPattern.matcher(userRequest.getEmail()).matches()) {
            throw new GenericException(UsersError.INVALID_EMAIL);
        }
        if (!passwordPattern.matcher(userRequest.getPassword()).matches()) {
            throw new GenericException(UsersError.INVALID_REQUEST);
        }
    }
}
