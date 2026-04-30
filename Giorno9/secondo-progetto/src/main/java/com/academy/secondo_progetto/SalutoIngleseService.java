package com.academy.secondo_progetto;

import org.springframework.stereotype.Service;

@Service
public class SalutoIngleseService implements SalutoService{
public String getSaluto(){
    return "Good morning";
 }
}
