package com.academy.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
public class SalutoController {

    @Value("${app.nome}")
    private String appNome;

    @Value("${app.versione}")
    private String appVersione;

    @Value("${app.messaggio-benvenuto}")
    private String appMessaggio;

    @Value("${server.port}")
    private String porta;

    @GetMapping("/saluto")
    public String sayHello() {
        return appMessaggio;
}
    @GetMapping("/info")
    public String getInfo() {
    return "{\"autore\": \"Veronica\", \"app\": \"" + appNome + "\", \"versione\": \"" + appVersione + "\"}";
}

@GetMapping("/app-info")
public String getApp() {
    return "App: " + appNome + ", Versione: " + appVersione + ", Messaggio: " + appMessaggio;
}

@GetMapping("/configurazione-server")
public String server() {
return "Il server è in ascolto sulla porta: " + porta;
}

}



    
    

