package com.academy.terzo_progetto.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.academy.terzo_progetto.entity.ProfiloStudente;
import com.academy.terzo_progetto.entity.Studente;
import com.academy.terzo_progetto.repository.ProfiloStudenteRepository;
import com.academy.terzo_progetto.repository.StudenteRepository;

@Component
public class DataLoader implements CommandLineRunner {

    
   @Autowired
    private StudenteRepository studenteRepo;

    @Override
    public void run(String... args) throws Exception {
        
        ProfiloStudente p1 = new ProfiloStudente();
        p1.setBio("Appassionato di programmazione Java e Backend.");
        p1.setLinkedin("linkedin.com/in/mariorossi");
        p1.setDataCreazione(LocalDateTime.now());

        Studente s1 = new Studente();
        s1.setNome("Mario");
        s1.setCognome("Rossi");
        s1.setEmail("mario.rossi@esempio.it");
        s1.setProfilo(p1);
        studenteRepo.save(s1);

        ProfiloStudente p2 = new ProfiloStudente();
        p2.setBio("Interessata a Data Science e AI.");
        p2.setDataCreazione(LocalDateTime.now());

        Studente s2 = new Studente();
        s2.setNome("Anna");
        s2.setCognome("Verdi");
        s2.setEmail("anna.verdi@esempio.it");
        s2.setProfilo(p2);
        studenteRepo.save(s2);

        Studente s3 = new Studente();
        s3.setNome("Luca");
        s3.setCognome("Neri");
        s3.setEmail("luca.neri@esempio.it");
        studenteRepo.save(s3);

        System.out.println("--- DATABASE POPOLATO ---");
    }
}
