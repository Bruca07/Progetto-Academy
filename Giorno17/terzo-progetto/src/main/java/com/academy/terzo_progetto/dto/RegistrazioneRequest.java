package com.academy.terzo_progetto.dto;

import lombok.Data;

@Data
public class RegistrazioneRequest {
    private String username;
    private String password;
    private String ruolo;
}
