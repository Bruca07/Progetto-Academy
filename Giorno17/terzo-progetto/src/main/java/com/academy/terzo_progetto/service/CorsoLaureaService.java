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

    public CorsoLaurea update(int id, CorsoLaurea c){
        corsoLaureaRepo.findById(id).orElseThrow();
        c.setId(id);
        return corsoLaureaRepo.save(c);
    }

     public void delete(int id) {
    CorsoLaurea corso = corsoLaureaRepo.findById(id).orElseThrow();
    if(!corso.getStudenti().isEmpty()) {
        throw new RuntimeException("Il corso ha studenti, impossibile eliminare");
    }else{
        corsoLaureaRepo.deleteById(id);
    }
    
}


   


    }

    

   


