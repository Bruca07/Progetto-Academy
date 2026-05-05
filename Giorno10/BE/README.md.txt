Tutte le chiamate sono state testate localmente all'indirizzo: http://localhost:8080/api/studenti

1. Inserimento Studente (POST)
Crea un nuovo studente. Nel test effettuato, il sistema ha assegnato automaticamente l'ID 4.

Metodo: POST

URL: /api/studenti

Body (JSON):
{
  "nome": "Luca",
  "cognome": "Neri",
  "email": "luca.neri@example.com",
  "data_nascita": "2001-11-20",
  "corso_laurea": "Fisica"
}

Risposta: 201 Created

2. Elenco Completo (GET)
Recupera la lista di tutti gli studenti presenti nel database.

Metodo: GET

URL: /api/studenti

Risposta: 200 OK

3. Aggiornamento Studente (PUT)
Modifica i dati di uno studente esistente tramite il suo ID.

Metodo: PUT

URL: /api/studenti/4

Body (JSON):

    {
      "nome": "Luca",
      "cognome": "Neri Bianchi",
      "email": "luca.neri@example.com",
      "data_nascita": "2001-11-20",
      "corso_laurea": "Scienze Motorie"
    }
    
Risposta:`200 OK` (oppure `404 Not Found` se l'ID è inesistente).

### 4. Eliminazione Studente (DELETE)
Rimuove definitivamente uno studente dal database.
  Metodo: DELETE
  URL: `/api/studenti/4`
  Risposta: `204 No Content`(conferma eliminazione avvenuta).
