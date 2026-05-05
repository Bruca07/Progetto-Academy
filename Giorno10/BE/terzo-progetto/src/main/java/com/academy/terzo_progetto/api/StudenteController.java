package com.academy.terzo_progetto.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.terzo_progetto.entity.Studente;
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
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Studente s = service.findById(id);
        if (s != null) {
            return ResponseEntity.ok(s);
        }
        return ResponseEntity.status(404).body("studente non trovato");
    }

    @PostMapping
public ResponseEntity<Studente> create(@RequestBody Studente s) {
    Studente nuovoStudente = service.save(s);
    return ResponseEntity.status(201).body(nuovoStudente); 
}

@PutMapping("/{id}")
public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Studente studenteDatiNuovi) {
    // 1. Controlliamo se lo studente esiste già
    Studente studenteEsistente = service.findById(id);

    if (studenteEsistente != null) {
        // 2. Importante: impostiamo l'ID altrimenti ne creerebbe uno nuovo invece di aggiornare
        studenteDatiNuovi.setId(id); 
        
        // 3. Salviamo le modifiche
        Studente salvato = service.update(studenteDatiNuovi);
        return ResponseEntity.ok(salvato);
    } else {
        // 4. Se non esiste, 404 come da traccia
        return ResponseEntity.status(404).body("Impossibile aggiornare: studente con ID " + id + " non trovato");
    }

  
}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        // 1. Controlla se esiste
        if (service.findById(id) != null) {
            service.deleteById(id);
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
}
}
    
    


