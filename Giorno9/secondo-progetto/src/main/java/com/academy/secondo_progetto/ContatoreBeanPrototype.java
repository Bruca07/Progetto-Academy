package com.academy.secondo_progetto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ContatoreBeanPrototype {

  private int contatore = 0;

    public void incrementa() {
        contatore++;
    }

    public int getContatore() {
        return contatore;
    }
}
