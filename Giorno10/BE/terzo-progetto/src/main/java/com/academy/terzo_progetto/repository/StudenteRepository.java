package com.academy.terzo_progetto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.academy.terzo_progetto.entity.Studente;

public interface StudenteRepository extends JpaRepository<Studente,Integer>  {

    @Query("SELECT s FROM Studente s WHERE s.corso_laurea= :corso")
     List<Studente>findByCorsoLaurea(String corso);
}
