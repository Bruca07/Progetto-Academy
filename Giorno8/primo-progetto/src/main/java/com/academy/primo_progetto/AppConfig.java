package com.academy.primo_progetto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AppConfig {
@Value("${app.nome}")
    private String nome;

    @Value("${app.versione}")
    private String versione;

    @PostConstruct
    public void stampaLogDiAvvio() {
        System.out.println("------------------------------------------");
        System.out.println("CONFIGURAZIONE CARICATA CORRETTAMENTE:");
        System.out.println("Nome App: " + nome);
        System.out.println("Versione: " + versione);
        System.out.println("------------------------------------------");
    }
}
