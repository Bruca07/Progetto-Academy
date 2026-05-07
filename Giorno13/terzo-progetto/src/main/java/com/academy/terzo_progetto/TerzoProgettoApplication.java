package com.academy.terzo_progetto;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.academy.terzo_progetto.entity.Studente;
import com.academy.terzo_progetto.repository.StudenteRepository;
import com.academy.terzo_progetto.service.StudenteService;

@SpringBootApplication
public class TerzoProgettoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerzoProgettoApplication.class, args);
	}

	@Bean
    public CommandLineRunner eseguiTest(StudenteService service, StudenteRepository repo) {
        return args -> {
            System.out.println("\n--- AVVIO TEST CRUD ---");

            // 1. CREA 3 STUDENTI
            Studente s1 = new Studente();
            s1.setNome("Mario");
            s1.setCognome("Rossi");
            s1.setCorsoLaurea("Informatica");
            s1.setData_nascita(LocalDate.of(2000, 1, 1));

            Studente s2 = new Studente();
            s2.setNome("Anna");
            s2.setCognome("Verdi");
            s2.setCorsoLaurea("Informatica");
            s2.setData_nascita(LocalDate.of(1999, 5, 15));

            Studente s3 = new Studente();
            s3.setNome("Luca");
            s3.setCognome("Neri");
            s3.setCorsoLaurea("Fisica");
            s3.setData_nascita(LocalDate.of(2001, 10, 20));

            service.save(s1);
            service.save(s2);
            service.save(s3);
            System.out.println("Salvati 3 studenti con successo.");

            // 2. LEGGILI TUTTI
            System.out.println("\nLista di tutti gli studenti:");
            repo.findAll().forEach(System.out::println);

         // 3. AGGIORNA IL CORSO DEL PRIMO (ID 1)
          s1.setCorsoLaurea("Ingegneria");
        // MODIFICA QUI: aggiungi l'ID prima dell'oggetto
          service.update(1, s1); 
          System.out.println("\nAggiornato corso di Mario in Ingegneria.");

            // 4. ELIMINA IL TERZO (Luca)
            service.deleteById(s3.getId());
            System.out.println("\nEliminato Luca (ID: " + s3.getId() + ")");

            // 5. QUERY PERSONALIZZATA PER CORSO
            System.out.println("\nStudenti rimasti nel corso di Informatica:");
            repo.findByCorsoLaurea("Informatica").forEach(System.out::println);

            System.out.println("\n--- FINE TEST CRUD ---");
        };
    }

}
