package com.academy.terzo_progetto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import com.academy.terzo_progetto.entity.Studente;

public interface StudenteRepository extends JpaRepository<Studente,Integer>  {

    
     List<Studente>findByCorsoLaurea(String corso);

    
    List<Studente> findByCognome(@Param("cognome") String cognome);

  
    List<Studente> findByNomeContaining(String parte);

}
