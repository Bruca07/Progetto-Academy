package com.academy.terzo_progetto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.terzo_progetto.entity.Studente;
import com.academy.terzo_progetto.exception.StudenteNotFoundException;
import com.academy.terzo_progetto.repository.StudenteRepository;

import jakarta.transaction.Transactional;

@Service
public class StudenteService {

    @Autowired
    StudenteRepository studenteRepo;

  

    public List<Studente> findAll() {
    return studenteRepo.findAll();
    }

   public Studente findById(int id) {
    return studenteRepo.findById(id)
            .orElseThrow(() -> new StudenteNotFoundException("Studente non trovato con id: " + id));
}

    public Studente save(Studente s){
        return studenteRepo.save(s);
    }

    @Transactional
    public Studente update(int id, Studente s) {
    // 1. Verifichiamo che esista (se non esiste lancia EntityNotFoundException)
    this.findById(id); 
    s.setId(id); 
    return studenteRepo.save(s);
}

    public void deleteById(int id) {
        this.findById(id); // Controlla se esiste prima di procedere
        studenteRepo.deleteById(id); // Cancella 
    }

    public List<Studente> cercaPerCognome(String cognome){
        return studenteRepo.findByCognome(cognome);
    }

   public String trovaCorsoPerId(int id) {
    Studente studente = studenteRepo.findById(id)
    .orElseThrow(() -> new StudenteNotFoundException("Studente non trovato con ID: " + id));
    return studente.getCorso_laurea();
}
}
