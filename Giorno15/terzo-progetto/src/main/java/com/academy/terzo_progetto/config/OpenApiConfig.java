package com.academy.terzo_progetto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gestione Studenti Academy")
                        .version("1.0")
                        .description("Documentazione interattiva delle API per la gestione dell'anagrafica studenti. " +
                                     "Il sistema permette operazioni CRUD, paginazione e ricerche personalizzate.")
                        .contact(new Contact()
                                .name("Il Tuo Nome")
                                .email("tua.email@esempio.it")));
    }
}
