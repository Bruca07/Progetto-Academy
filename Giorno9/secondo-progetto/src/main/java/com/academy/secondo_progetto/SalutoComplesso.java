package com.academy.secondo_progetto;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class SalutoComplesso {
    // Viene chiamato automaticamente da Spring dopo la creazione del bean
 @PostConstruct
    public void init() {
        System.out.println("Bean inizializzato!");
    }

    // Viene chiamato automaticamente da Spring prima della chiusura dell'app
    @PreDestroy
    public void cleanup() {
        System.out.println("Bean distrutto!");
    }
}
