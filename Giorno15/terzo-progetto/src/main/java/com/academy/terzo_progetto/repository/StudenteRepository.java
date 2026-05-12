package com.academy.terzo_progetto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academy.terzo_progetto.entity.Esame;
import com.academy.terzo_progetto.entity.Studente;

public interface StudenteRepository extends JpaRepository<Studente,Integer>  {

    
     List<Studente> findByCorsoLaureaNome(String nome);

    
    List<Studente> findByCognome(@Param("cognome") String cognome);

  
    List<Studente> findByNomeContaining(String parte);

    @Query("SELECT e FROM Studente s JOIN s.esami e WHERE s.id = :id ORDER BY e.dataEsame")
    List<Esame> findEsamiByStudenteId(int id);

    @Query("SELECT AVG(e.voto) FROM Studente s JOIN s.esami e WHERE s.id = :id")
    Double calcolaMedia(@Param("id") int id);

}
