package com.ejercicio.registro.usuarios.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user.validation")
@Getter
@Setter
public class UserProperties {
    private String emailRegex;
    private String passwordRegex;
}
