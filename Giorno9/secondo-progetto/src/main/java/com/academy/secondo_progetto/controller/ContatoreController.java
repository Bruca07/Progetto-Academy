package com.academy.secondo_progetto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.secondo_progetto.ContatoreBeanPrototype;
import com.academy.secondo_progetto.ContatoreBeanSingleton;
/*
 * @Primary e @Qualifier:
 * Ho due classi che implementano la stessa interfaccia.
 * Per far capire a Spring quale deve usare, utilizzo @Primary nella classe come default
 * e @Qualifier lo utilizzo nel costruttore della classe controller per scegliere caso per caso.
 *
 * Singleton e Prototype:
 * Lo scope singleton è quello di default: Spring dà a tutte le classi
 * che richiedono quel bean lo stesso oggetto.
 * Lo scope prototype invece crea ogni volta un oggetto nuovo.
 */
@RestController
public class ContatoreController {

    private ContatoreBeanSingleton singleton;
    private ContatoreBeanPrototype prototype;

     public ContatoreController(ContatoreBeanSingleton singleton, ContatoreBeanPrototype prototype) {
        this.singleton = singleton;
        this.prototype = prototype;
    }

    @GetMapping("/contatore")
    public String contatore() {
        singleton.incrementa();
        return "SINGLETON: " + singleton.getContatore();
    }

    @GetMapping("/contatore-prototype")
    public String contatorePrototype() {
        prototype.incrementa();
        return "PROTOTYPE: " + prototype.getContatore();
    }

}
