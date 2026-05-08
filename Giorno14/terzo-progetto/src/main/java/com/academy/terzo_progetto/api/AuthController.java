package com.academy.terzo_progetto.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.academy.terzo_progetto.dto.RegistrazioneRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

     @Autowired
    private JdbcUserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registrazione")
public ResponseEntity<String> registra(@RequestBody RegistrazioneRequest request) {
    
    if (userDetailsManager.userExists(request.getUsername())) {
        return ResponseEntity.status(409).body("Username già esistente");
    }

    UserDetails nuovoUtente = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .roles(request.getRuolo())
        .build();

    userDetailsManager.createUser(nuovoUtente);

    return ResponseEntity.status(201).body("Utente creato con successo");
}
}
