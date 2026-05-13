Scenari Edge Case
1. Eliminazione corso con studenti associati
Richiesta: DELETE http://localhost:8080/api/corsi/1
Risposta:500 Internal Server Error
Non è possibile eliminare un corso che ha ancora studenti iscritti.
Per eliminare il corso, è necessario prima spostare o eliminare tutti gli studenti associati.

 Aggiornamento esame con voto non valido (es. 17)
Richiesta:POST http://localhost:8080/api/studenti/32/esami
Body:
{
    "materia": "Chimica",
    "voto": 17,
    "dataEsame": "2025-10-10",
    "lode": false
}
 Il voto 17 è inferiore al minimo consentito (18). La validazione con @Min(18) e @Max(30) blocca la richiesta.
Risposta:400 Bad Request
{
    "voto": "deve essere superiore o uguale a 18"
}
 I voti universitari validi vanno da 18 a 30. Qualsiasi valore fuori da questo range viene rifiutato con un messaggio esplicativo.