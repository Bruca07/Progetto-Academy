package com.academy.terzo_progetto.service;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.academy.terzo_progetto.dto.MediaDTO;
import com.academy.terzo_progetto.entity.CorsoLaurea;
import com.academy.terzo_progetto.entity.Esame;
import com.academy.terzo_progetto.entity.ProfiloStudente;
import com.academy.terzo_progetto.entity.Studente;
import com.academy.terzo_progetto.exception.StudenteNotFoundException;
import com.academy.terzo_progetto.repository.CorsoLaureaRepository;
import com.academy.terzo_progetto.repository.StudenteRepository;

import jakarta.transaction.Transactional;

@Service
public class StudenteService {

    @Autowired
    StudenteRepository studenteRepo;

    @Autowired
    CorsoLaureaRepository corsoLaureaRepo;

  

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
    
    // Se lo studente ha un corso, restituisci il NOME del corso (stringa)
    return (studente.getCorsoLaurea() != null) ? studente.getCorsoLaurea().getNome() : "Nessun corso";
}

    public List<Studente> trovaParteNome(String nome) {
        return studenteRepo.findByNomeContaining(nome);
    }

    public List<Studente> cercaPerCorso(String corso) {
    return studenteRepo.findByCorsoLaureaNome(corso);     
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
                System.out.println("Aggiornamento corso laurea tramite patch non ancora implementato come oggetto");
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

public List<Esame> cercaEsame(int id){
   return  studenteRepo.findEsamiByStudenteId(id);
}

public Esame aggiungiEsame(int id, Esame esame) {
    Studente studente = studenteRepo.findById(id).orElseThrow();
    studente.getEsami().add(esame);
    studenteRepo.save(studente);
    return studente.getEsami().get(studente.getEsami().size() - 1);
}

public MediaDTO getMedia(int id) {
    Studente studente = studenteRepo.findById(id).orElseThrow();
    Double media = studenteRepo.calcolaMedia(id);
    int totaleEsami = studente.getEsami().size();
    
    MediaDTO dto = new MediaDTO();
    dto.setStudente(studente.getNome() + " " + studente.getCognome());
    dto.setMedia(media != null ? media : 0.0);
    dto.setTotaleEsami(totaleEsami);
    
    return dto;
}

 public Studente spostaCorso(int id, int corsoId){
        Studente s = studenteRepo.findById(id).orElseThrow();
        CorsoLaurea c = corsoLaureaRepo.findById(corsoId).orElseThrow();
        s.setCorsoLaurea(c);
        return studenteRepo.save(s);

    }

    public void eliminareEsame(int id, int esameId) {
    Studente s = studenteRepo.findById(id).orElseThrow();

//scorri tutti gli esami dello studente, quando trovi quello con l'id giusto rimuovilo
    for(Esame e : s.getEsami()) {
        if(e.getId() == esameId) {
            s.getEsami().remove(e);
            break;
        }
    }
    
    studenteRepo.save(s);
}
 public Studente aggiornamentoVoto(int id,int esameId,int voto){
    Studente s = studenteRepo.findById(id).orElseThrow();
    for(Esame e : s.getEsami()){
        if(e.getId()==esameId){
            e.setVoto(voto);
            break;
        }

    }
    studenteRepo.save(s);
    return s;
 }





}
