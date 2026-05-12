package com.academy.terzo_progetto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.terzo_progetto.entity.CorsoLaurea;
import com.academy.terzo_progetto.repository.CorsoLaureaRepository;

@Service
public class CorsoLaureaService {


    @Autowired
    CorsoLaureaRepository corsoLaureaRepo;

    public List <CorsoLaurea> findAll(){
        return corsoLaureaRepo.findAll();
    }


    public CorsoLaurea getCorsoConstudenti(int id){
    return corsoLaureaRepo.trovaCorsoPerId(id);

    }

        public List <Object[]> getNumeroStudenti(){
            return corsoLaureaRepo.CercaNumeroStudenti();
        }
    }

    

   


