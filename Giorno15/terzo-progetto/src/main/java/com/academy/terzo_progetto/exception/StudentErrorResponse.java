package com.academy.terzo_progetto.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentErrorResponse {
private int status;
private int id;
private String errore;
private String timeStamp;


}
