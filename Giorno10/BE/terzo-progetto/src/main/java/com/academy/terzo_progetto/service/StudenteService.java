package com.academy.terzo_progetto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.terzo_progetto.entity.Studente;
import com.academy.terzo_progetto.repository.StudenteRepository;

import jakarta.transaction.Transactional;

@Service
public class StudenteService {

    @Autowired
    StudenteRepository studenteRepo;

  

    public List<Studente> findAll() {
    return studenteRepo.findAll();
    }

    public Studente findById(int id){
        return studenteRepo.findById(id).orElse(null);
    }

    public Studente save(Studente s){
        return studenteRepo.save(s);
    }

    @Transactional

    public Studente update(Studente s){
        return studenteRepo.save(s);
    }

    public void deleteById(int id){
        studenteRepo.deleteById(id);
    }
}
