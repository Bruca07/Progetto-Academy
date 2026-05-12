package com.academy.terzo_progetto.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
public class Esame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String materia;
    @Min(18)
    @Max(30)
    private int voto;
    private LocalDate dataEsame;
    private boolean lode;


    
    
}
