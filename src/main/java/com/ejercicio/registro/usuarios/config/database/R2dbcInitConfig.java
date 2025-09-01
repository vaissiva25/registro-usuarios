package com.ejercicio.registro.usuarios.config.database;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Configuration
public class R2dbcInitConfig {

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory cf) {
        var initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(cf);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(
                new ClassPathResource("schema.sql")));
        return initializer;
    }
}
