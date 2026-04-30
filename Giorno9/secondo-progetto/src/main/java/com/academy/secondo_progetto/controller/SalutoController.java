package com.academy.secondo_progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.academy.secondo_progetto.SalutoService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class SalutoController {

    private SalutoService salutoService;

    @Autowired
    public SalutoController(@Qualifier("salutoIngleseService")SalutoService salutoService){
        this.salutoService = salutoService;
    }

    @GetMapping("/saluto")
   public String getSaluto() {
        return salutoService.getSaluto();
    
}
}