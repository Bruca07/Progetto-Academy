package com.academy.terzo_progetto.entity;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "studenti")
@Schema(description = "Rappresenta l'anagrafica di uno studente all'interno del sistema")
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificativo univoco dello studente", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(nullable = false)
    @Schema(description = "Nome dello studente", example = "Mario", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nome;

    @Column(nullable = false)
    @Schema(description = "Cognome dello studente", example = "Rossi", requiredMode = Schema.RequiredMode.REQUIRED)
    private String cognome;

    @Schema(description = "Indirizzo email istituzionale o privato", example = "mario.rossi@esempio.it")
    private String email;

    @Schema(description = "Data di nascita dello studente", example = "2000-01-01")
    private LocalDate data_nascita;

    @Schema(description = "Corso di laurea a cui lo studente è iscritto", example = "Informatica")
    private String corsoLaurea;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profilo_id")
    ProfiloStudente  profilo;


    
 
}
