package org.abdessamadg.backendprogetto.API;

import lombok.RequiredArgsConstructor;
import org.abdessamadg.backendprogetto.SERVICES.DTO.UtenteDto;
import org.abdessamadg.backendprogetto.SERVICES.UtenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ModificaUtenteController {
    private final UtenteService utenteService;

    @PutMapping("/modifica/{codiceFiscale}")
    public ResponseEntity<?> aggiornaUtente(@PathVariable String codiceFiscale, @RequestBody UtenteDto nuovoUtenteDto) {
        UtenteDto utenteEsistente = utenteService.getUtenteByCodiceFiscale(codiceFiscale);
        if (utenteEsistente != null) {

            utenteEsistente.setNome(nuovoUtenteDto.getNome());
            utenteEsistente.setCognome(nuovoUtenteDto.getCognome());
            utenteEsistente.setOrganizzazione(nuovoUtenteDto.getOrganizzazione());
            utenteEsistente.setCategoria(nuovoUtenteDto.getCategoria());
            utenteEsistente.setUrlFotoProfilo(nuovoUtenteDto.getUrlFotoProfilo());

            UtenteDto utenteAggiornato = utenteService.aggiornaUtente(utenteEsistente);

            return ResponseEntity.ok(utenteAggiornato);
        } else {
            return ResponseEntity.badRequest().body("Utente non trovato");
        }
    }
}
