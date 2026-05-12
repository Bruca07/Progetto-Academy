package com.academy.terzo_progetto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.academy.terzo_progetto.entity.CorsoLaurea;

public interface CorsoLaureaRepository extends JpaRepository<CorsoLaurea,Integer> {

    @Query("SELECT c FROM CorsoLaurea c JOIN FETCH c.studenti WHERE c.id =:id")
    public CorsoLaurea trovaCorsoPerId(int id);

    @Query("SELECT c.nome, COUNT(s)FROM CorsoLaurea c JOIN c.studenti s GROUP BY c.nome")
    public List <Object[]> CercaNumeroStudenti();

    boolean existsByNome(String nome);

}
