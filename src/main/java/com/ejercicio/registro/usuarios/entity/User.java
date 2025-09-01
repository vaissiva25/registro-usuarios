package com.ejercicio.registro.usuarios.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("USERS")
@Getter
@Setter
@NoArgsConstructor
public class User implements Persistable<UUID> {
    @Id
    private UUID id;
    @Column("NAME")
    private String name;
    @Column("EMAIL")
    private String email;
    @Column("PASSWORD")
    private String password;
    @Column("CREATED")
    private LocalDateTime created;
    @Column("MODIFIED")
    private LocalDateTime modified;
    @Column("LAST_LOGIN")
    private LocalDateTime lastLogin;
    @Column("TOKEN")
    private String token;
    @Column("IS_ACTIVE")
    private boolean isActive;
    @Transient
    private boolean newAggregate = true;

    @Override
    public boolean isNew() {
        return newAggregate;
    }
}
