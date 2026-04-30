package com.academy.secondo_progetto;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SalutoItalianoService implements SalutoService{
 public String getSaluto(){
    return "Buongiorno!";
 }
}
