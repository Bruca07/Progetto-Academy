package com.academy.terzo_progetto.exception;

public class StudenteNotFoundException extends RuntimeException{
public StudenteNotFoundException(String message) {
        super(message);// message= messaggio di erroe
    }
}
