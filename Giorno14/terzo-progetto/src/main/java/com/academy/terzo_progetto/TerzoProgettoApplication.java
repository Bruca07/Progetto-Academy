package com.academy.terzo_progetto;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.academy.terzo_progetto.entity.Studente;
import com.academy.terzo_progetto.repository.StudenteRepository;
import com.academy.terzo_progetto.service.StudenteService;

@SpringBootApplication
public class TerzoProgettoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerzoProgettoApplication.class, args);
    }
}