package com.academy.terzo_progetto.entity;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "profilo_sutente")
public class ProfiloStudente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bio;
    private String linkedin;

    @Column(name = "foto_url")
    private String fotoUrl;
    @Column(name = "data_creazione")
    private LocalDateTime dataCreazione;

    @OneToOne(mappedBy = "profilo") 
    @JsonIgnore 
    private Studente studente;
}
