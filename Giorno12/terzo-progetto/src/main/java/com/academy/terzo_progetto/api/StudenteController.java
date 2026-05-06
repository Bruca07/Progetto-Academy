package com.academy.terzo_progetto.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.terzo_progetto.entity.Studente;
import com.academy.terzo_progetto.repository.StudenteRepository;
import com.academy.terzo_progetto.service.StudenteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/studenti")
public class StudenteController {

    @Autowired
    StudenteService service;

    @GetMapping
    public List <Studente> findAll(){
        return service.findAll();
    }

     @GetMapping("/{id}")
    public Studente findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Studente> create(@RequestBody Studente s) {
        return ResponseEntity.status(201).body(service.save(s));
    }

    @PutMapping("/{id}")
    public Studente update(@PathVariable int id, @RequestBody Studente s) {
        return service.update(id, s);
    }
  
   @DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable int id) {
    service.findById(id); 
    return ResponseEntity.noContent().build(); 
}

    @GetMapping("/cerca")
 public List<Studente> findByCognome(@RequestParam String cognome) {
    List<Studente> listaStudenti = service.cercaPerCognome(cognome);
    return listaStudenti;
 }
 
 @GetMapping("/{id}/corso")
 public String getCorsoByStudenteId(@PathVariable int id) {
    return service.trovaCorsoPerId(id);
 }
 
}





    
    


