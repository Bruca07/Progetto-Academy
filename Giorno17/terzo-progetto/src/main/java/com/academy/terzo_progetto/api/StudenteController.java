package com.academy.terzo_progetto.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.terzo_progetto.dto.MediaDTO;
import com.academy.terzo_progetto.entity.Esame;
import com.academy.terzo_progetto.entity.ProfiloStudente;
import com.academy.terzo_progetto.entity.Studente;
import com.academy.terzo_progetto.service.StudenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/studenti")
@Tag(name = "Studenti", description = "API per la gestione completa dell'anagrafica degli studenti")
public class StudenteController {

    @Autowired
    StudenteService service;

    @GetMapping
    @Operation(summary = "Recupera la lista paginata degli studenti", description = "Restituisce una pagina di studenti in base ai parametri di paginazione e ordinamento")
    public Page<Studente> findAll(Pageable p) {
    return service.findAll(p);
}

     @GetMapping("/{id}")
     @Operation(summary = "Cerca uno studente per ID", description = "Restituisce i dettagli di un singolo studente specificando il suo identificativo univoco")
     @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Studente trovato con successo"),
    @ApiResponse(responseCode = "404", description = "Studente non trovato per l'ID fornito")
})
    public Studente findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crea un nuovo studente", description = "Inserisce un nuovo studente nel database. L'ID viene generato automaticamente.")
    @ApiResponse(responseCode = "201", description = "Studente creato correttamente")
    @ApiResponse(responseCode = "400", description = "Dati forniti non validi")
    public ResponseEntity<Studente> create(@RequestBody Studente s) {
        return ResponseEntity.status(201).body(service.save(s));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Aggiorna uno studente esistente", description = "Modifica i dati di uno studente già presente a sistema cercandolo per ID")
    public Studente update(@PathVariable int id, @RequestBody Studente s) {
        return service.update(id, s);
    }
  
   @DeleteMapping("/{id}")
   @Operation(summary = "Elimina uno studente", description = "Rimuove definitivamente uno studente dal database tramite il suo ID")
   @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Studente eliminato con successo"),
    @ApiResponse(responseCode = "404", description = "Impossibile eliminare: studente non trovato")
})
    public ResponseEntity<Void> delete(@PathVariable int id) {
    service.deleteById(id); 
    return ResponseEntity.noContent().build(); 
}

    @GetMapping("/cerca")
    @Operation(summary = "Cerca studenti per cognome", description = "Restituisce una lista di studenti che hanno l'esatto cognome specificato come parametro query")
 public List<Studente> findByCognome(@RequestParam String cognome) {
    List<Studente> listaStudenti = service.cercaPerCognome(cognome);
    return listaStudenti;
 }
 
 @GetMapping("/{id}/corso")
 @Operation(summary = "Recupera il corso di uno studente", description = "Restituisce il nome del corso di laurea associato allo studente identificato dall'ID")
 public String getCorsoByStudenteId(@PathVariable int id) {
    return service.trovaCorsoPerId(id);
 }

 @GetMapping("/nome/{nome}")
 @Operation(summary = "Cerca studenti per parte del nome", description = "Restituisce tutti gli studenti il cui nome contiene la stringa specificata (case-insensitive)")
 public List<Studente> findByNomeContainig(@PathVariable String nome){
    return service.trovaParteNome(nome);
 }

 @GetMapping("/corso/{corso}") 
 @Operation(summary = "Filtra studenti per corso di laurea", description = "Restituisce l'elenco degli studenti iscritti a un determinato corso di laurea")
public List<Studente> findByCorso(@PathVariable String corso) {
    return service.cercaPerCorso(corso);
}

@PatchMapping("/{id}")
@Operation(summary = "Aggiornamento parziale studente", description = "Permette di modificare solo alcuni campi dello studente (es. solo l'email o solo il corso) passando una mappa chiave-valore")
public ResponseEntity<Void> aggiornaStudente(@PathVariable int id, @RequestBody Map<String, Object> campiDaAggiornare) {
    service.patch(id, campiDaAggiornare); 
    return ResponseEntity.noContent().build(); 
}

@GetMapping("/{id}/profilo")
public ResponseEntity<ProfiloStudente> getProfilo(@PathVariable int id) {
    try {
        ProfiloStudente profilo = service.findProfiloById(id);
        return ResponseEntity.ok(profilo);
    } catch (RuntimeException e) {
        return ResponseEntity.notFound().build();
    }
}

@GetMapping("/{id}/esami")
public  List<Esame> findEsamiByStudenteId(@PathVariable int id){
return service.cercaEsame(id);
}

@PostMapping("/{id}/esami")
public Esame aggiungiEsame(@PathVariable int id, @RequestBody @Valid Esame esame) {
    return service.aggiungiEsame(id, esame);
}

@GetMapping("/{id}/media")
public MediaDTO getMedia(@PathVariable int id) {
    return service.getMedia(id);
}

  @PatchMapping("/{id}/corso")
public ResponseEntity<Studente> aggiornamentoCorso(@PathVariable int id, @RequestBody Map<String, Integer> body) {
    try {
        int corsoId = body.get("corsoId");
        Studente s = service.spostaCorso(id, corsoId);
        return ResponseEntity.ok(s);
    } catch (RuntimeException e) {
        return ResponseEntity.notFound().build();
    }
}

@DeleteMapping("/{id}/esami/{esameId}")
public ResponseEntity<Void> delete(@PathVariable int id, @PathVariable int esameId){
    service.eliminareEsame(id, esameId);
    return ResponseEntity.noContent().build();
}

@PutMapping("/{id}/esami/{esameId}")
public Studente updateStudente(@PathVariable int id, @PathVariable  int esameId, @RequestBody int voto){
    return service.aggiornamentoVoto(id,  esameId, voto);
}
}







 






    
    


