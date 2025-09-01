package com.ejercicio.registro.usuarios.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table(name = "PHONES")
@Getter
@Setter
@NoArgsConstructor
public class Phone implements Persistable<UUID> {
    @Id
    private UUID id;
    @Column("USER_ID")
    private UUID userId;
    @Column("PHONE_NUMBER")
    private String number;
    @Column("CITY_CODE")
    private String cityCode;
    @Column("COUNTRY_CODE")
    private String countryCode;
    @Transient
    private boolean newAggregate = true;

    @Override
    public boolean isNew() {
        return newAggregate;
    }
}
