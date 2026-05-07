### Esito Test Paginazione
**Endpoint:** `GET /api/studenti?page=0&size=20&sort=cognome,asc`

**Esempio di Risposta JSON:**
 "content": [
        {
            "id": 1,
            "nome": "Mario",
            "cognome": "Rossi",
            "email": null,
            "data_nascita": "2000-01-01",
            "corsoLaurea": "Ingegneria"
        },
        {
            "id": 2,
            "nome": "Anna",
            "cognome": "Verdi",
            "email": null,
            "data_nascita": "1999-05-15",
            "corsoLaurea": "Informatica"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 20,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 2,
    "first": true,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "numberOfElements": 2,
    "empty": false
}

**Legenda Metadati:**
- **content**: La lista effettiva degli oggetti Studente.
- **pageable**: Informazioni sulla configurazione della pagina (numero, dimensione).
- **totalElements**: Numero totale di record nel database.
- **totalPages**: Numero di pagine totali disponibili.