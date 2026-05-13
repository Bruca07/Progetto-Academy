package com.academy.terzo_progetto.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.terzo_progetto.entity.CorsoLaurea;
import com.academy.terzo_progetto.service.CorsoLaureaService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/corsi")
public class CorsoLaureaController {

    @Autowired
    CorsoLaureaService service;

    @GetMapping
    public List<CorsoLaurea> findAll(){
    return service.findAll();
    }

    @GetMapping("/{id}/studenti")
  public CorsoLaurea findById(@PathVariable int id) {
        return service.getCorsoConstudenti(id);
    }

// sto contando gli studenti per corso.
    @GetMapping("/conta")
    public List <Object[]>CercaNumeroStudenti(){
        return service.getNumeroStudenti();
    }

    @PutMapping("/{id}")
    public CorsoLaurea update(@PathVariable int id, @RequestBody CorsoLaurea c) {
       return service.update(id,c); 
        
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
    service.delete(id); 
    return ResponseEntity.noContent().build(); 
}

 
}