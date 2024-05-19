package org.abdessamadg.backendprogetto.API;

import lombok.RequiredArgsConstructor;
import org.abdessamadg.backendprogetto.SERVICES.DTO.CredenzialiDto;
import org.abdessamadg.backendprogetto.SERVICES.DTO.SignUpDto;
import org.abdessamadg.backendprogetto.SERVICES.DTO.UtenteDto;
import org.abdessamadg.backendprogetto.SERVICES.UtenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class AutenticazioneController {
    private final UtenteService utenteService;

    @PostMapping("/login")
    public ResponseEntity<UtenteDto> login(@RequestBody CredenzialiDto  credenzialiDto){
        UtenteDto utente = utenteService .login(credenzialiDto);
        return ResponseEntity.ok(utente);
    }

    @PostMapping("/registrazione")
    public ResponseEntity<UtenteDto> registrazione(@RequestBody SignUpDto signUpDto){
        UtenteDto utente = utenteService.registrazione(signUpDto);
        return ResponseEntity.created(URI.create("/profilazione" + utente.getCodiceFiscale())).body(utente);
    }
}
