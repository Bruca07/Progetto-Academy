package com.academy.secondo_progetto;

import org.springframework.stereotype.Component;

@Component
public class ContatoreBeanSingleton {

 private int contatore = 0;

    public void incrementa() {
        contatore++;
    }

    public int getContatore() {
        return contatore;
    }

}
