# Progetto Spring Boot - Giorno 8

Esercitazione su configurazioni, profili e annotazioni.

 Come avviare il progetto
1. Aprire il progetto sull'IDE.
2. Verificare che in `application.properties` sia attivo il profilo `dev`.
3. Avviare l'app tramite la classe `PrimoProgettoApplication.java`.
4. Cambio porta: L'app non usa più la porta di default (8080), ma risponde alla 8081.

Endpoint da testare:
 http://localhost:8081/app-info: Legge i dati dai profili e mostra il messaggio di benvenuto.
http://localhost:8081/configurazione-server: Conferma che il server è passato sulla porta 8081.
http://localhost:8081/actuator: Mostra i servizi di monitoraggio sbloccati.

- @Value: Usato per "iniettare" la porta e i messaggi nel codice Java.
- @PostConstruct: Creato un messaggio automatico che appare nella console di Eclipse appena l'app è pronta.
- @Component: Serve a dire a Spring: "Gestisci tu questa classe". Senza questa etichetta, la classe AppConfig 
resterebbe un semplice file spento.
-Profili: Gestione di file diversi (`application-dev` e `application-prod`) per cambiare comportamento all'app senza cambiare il codice.


