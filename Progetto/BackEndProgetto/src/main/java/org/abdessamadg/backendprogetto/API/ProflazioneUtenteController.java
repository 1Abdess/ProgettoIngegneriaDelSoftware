package org.abdessamadg.backendprogetto.API;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.abdessamadg.backendprogetto.SERVICES.UtenteService;
import org.abdessamadg.backendprogetto.SERVICES.DTO.UtenteDto;

@RestController
@RequiredArgsConstructor
public class ProflazioneUtenteController {
    private final UtenteService utenteService;

    @GetMapping("/profilazione/{codiceFiscale}")
    public ResponseEntity<?> getUtenteByCodiceFiscale(@PathVariable String codiceFiscale) {
        UtenteDto utente = utenteService.getUtenteByCodiceFiscale(codiceFiscale);
        if (utente != null) {
            utente.setPassword(null);
            return ResponseEntity.ok(utente);
        } else {
            return ResponseEntity.badRequest().body("Codice fiscale inesistente");
        }
    }

}
