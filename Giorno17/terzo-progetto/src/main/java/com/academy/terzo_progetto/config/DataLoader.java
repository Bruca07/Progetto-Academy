package com.academy.terzo_progetto.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.academy.terzo_progetto.entity.CorsoLaurea;
import com.academy.terzo_progetto.entity.Esame;
import com.academy.terzo_progetto.entity.ProfiloStudente;
import com.academy.terzo_progetto.entity.Studente;
import com.academy.terzo_progetto.repository.CorsoLaureaRepository;
import com.academy.terzo_progetto.repository.StudenteRepository;

@Component
public class DataLoader implements CommandLineRunner {

    
   @Autowired
    private StudenteRepository studenteRepo;

    @Autowired
    private CorsoLaureaRepository corsoLaureaRepo;

 

    @Override
    public void run(String... args) throws Exception {

        CorsoLaurea c1 = new CorsoLaurea();
        c1.setNome("Informatica");
        c1.setDipartimento("Scienze");
        c1.setDurataAnni(3);
        if(corsoLaureaRepo.existsByNome("Informatica")) {
        } else {
            corsoLaureaRepo.save(c1); // Qui salviamo il corso.
        }

        CorsoLaurea c2 = new CorsoLaurea();
        c2.setNome("Lettere");
        c2.setDipartimento("Studi Umanistici");
        c2.setDurataAnni(3);
        if(corsoLaureaRepo.existsByNome("Lettere")){   
        }else{
            corsoLaureaRepo.save(c2);
        }
         

        CorsoLaurea c3 = new CorsoLaurea();
        c3.setNome("Giurisprudenza");
        c3.setDipartimento("Studi Giuridici");
        c3.setDurataAnni(5);
        if(corsoLaureaRepo.existsByNome("Giurisprudenza")){

        }else{
            corsoLaureaRepo.save(c3);
        }
        
        Esame e1 = new Esame();
        e1.setDataEsame(LocalDate.of(2025, 10, 3));
        e1.setLode(true);
        e1.setMateria("Italiano");
        e1.setVoto(30);
       

        Esame e2 = new Esame();
        e2.setMateria("Matematica");
        e2.setVoto(27);
        e2.setLode(false);
        e2.setDataEsame(LocalDate.of(2025, 11, 15));

        Esame e3 = new Esame();
        e3.setMateria("Fisica");
        e3.setVoto(24);
        e3.setLode(false);
        e3.setDataEsame(LocalDate.of(2025, 12, 5));



        Esame e4 = new Esame();
        e4.setMateria("Storia");
        e4.setVoto(28);
        e4.setLode(false);
        e4.setDataEsame(LocalDate.of(2025, 10, 10));

        Esame e5 = new Esame();
        e5.setMateria("Filosofia");
        e5.setVoto(25);
        e5.setLode(false);
        e5.setDataEsame(LocalDate.of(2025, 11, 20));



        
        ProfiloStudente p1 = new ProfiloStudente();
        p1.setBio("Appassionato di programmazione Java e Backend.");
        p1.setLinkedin("linkedin.com/in/mariorossi");
        p1.setDataCreazione(LocalDateTime.now());

        Studente s1 = new Studente();
        s1.setNome("Mario");
        s1.setCognome("Rossi");
        s1.setEmail("mario.rossi@esempio.it");
        s1.setProfilo(p1);
        s1.setEsami(List.of(e1, e2, e3));
        studenteRepo.save(s1);

        ProfiloStudente p2 = new ProfiloStudente();
        p2.setBio("Interessata a Data Science e AI.");
        p2.setDataCreazione(LocalDateTime.now());

        Studente s2 = new Studente();
        s2.setNome("Anna");
        s2.setCognome("Verdi");
        s2.setEmail("anna.verdi@esempio.it");
        s2.setProfilo(p2);
        s2.setEsami(List.of(e4, e5));
        studenteRepo.save(s2);

        Studente s3 = new Studente();
        s3.setNome("Luca");
        s3.setCognome("Neri");
        s3.setEmail("luca.neri@esempio.it");
        studenteRepo.save(s3);

        System.out.println("--- DATABASE POPOLATO ---");
    }

        

        
}
