package com.ejercicio.registro.usuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PhoneRequest implements Serializable {
    private String number;
    private String cityCode;
    private String countryCode;
}
