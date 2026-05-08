package com.academy.terzo_progetto.service;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.academy.terzo_progetto.entity.ProfiloStudente;
import com.academy.terzo_progetto.entity.Studente;
import com.academy.terzo_progetto.exception.StudenteNotFoundException;
import com.academy.terzo_progetto.repository.StudenteRepository;

import jakarta.transaction.Transactional;

@Service
public class StudenteService {

    @Autowired
    StudenteRepository studenteRepo;

  

   public Page<Studente> findAll(Pageable p) {
    return studenteRepo.findAll(p);
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
    return studente.getCorsoLaurea();
}

    public List<Studente> trovaParteNome(String nome) {
        return studenteRepo.findByNomeContaining(nome);
    }

    public List<Studente> cercaPerCorso(String corso) {
    return studenteRepo.findByCorsoLaurea(corso);     
}

@Transactional
public Studente patch(int id, Map<String, Object> updates) {
    // 1. Recuperi lo studente esistente
    Studente studenteEsistente = this.findById(id);

    // 2. Cicli la mappa e aggiorni solo i campi presenti
    updates.forEach((chiave, valore) -> {
        switch (chiave) {
            case "nome":
                studenteEsistente.setNome((String) valore);
                break;
            case "cognome":
                studenteEsistente.setCognome((String) valore);
                break;
            case "corso_laurea":
                studenteEsistente.setCorsoLaurea((String) valore);
                break;
        }
    });

    // 3. Salvi l'oggetto modificato
    return studenteRepo.save(studenteEsistente);
}

public ProfiloStudente findProfiloById(int id) {
    Studente studente = studenteRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Studente non trovato"));
    
    if (studente.getProfilo() == null) {
        throw new RuntimeException("Profilo non trovato");
    }
    
    return studente.getProfilo();
}






}
