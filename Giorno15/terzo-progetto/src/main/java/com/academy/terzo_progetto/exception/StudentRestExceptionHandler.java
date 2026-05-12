package com.academy.terzo_progetto.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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


    @ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException exc) {
    Map<String, String> errori = new HashMap<>();
    exc.getBindingResult().getFieldErrors().forEach(error -> 
        errori.put(error.getField(), error.getDefaultMessage())
    );
    return new ResponseEntity<>(errori, HttpStatus.BAD_REQUEST);
}
}
