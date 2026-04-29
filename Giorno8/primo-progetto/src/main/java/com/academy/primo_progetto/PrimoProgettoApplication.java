package com.academy.primo_progetto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {"com.academy.primo_progetto", "com.academy.controller"})
public class PrimoProgettoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimoProgettoApplication.class, args);
	}

}
