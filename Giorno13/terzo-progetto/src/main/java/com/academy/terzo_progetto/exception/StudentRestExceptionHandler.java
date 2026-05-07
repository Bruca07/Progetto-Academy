package com.academy.terzo_progetto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

   @ExceptionHandler(StudenteNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleNotFound(StudenteNotFoundException exc) {

        // Usiamo il costruttore pieno
        StudentErrorResponse error = new StudentErrorResponse();
                error.setErrore("Studente non trovato");
                error.setId(99);
                error.setTimeStamp(String.valueOf(System.currentTimeMillis()));
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        
    }
}
