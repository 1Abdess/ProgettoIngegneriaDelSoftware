package org.abdessamadg.backendprogetto.API;

import lombok.RequiredArgsConstructor;
import org.abdessamadg.backendprogetto.SERVICES.CONFIG.SECURITY.UserAuthProvider;
import org.abdessamadg.backendprogetto.SERVICES.DTO.CredenzialiDto;
import org.abdessamadg.backendprogetto.SERVICES.DTO.SignUpDto;
import org.abdessamadg.backendprogetto.SERVICES.DTO.UtenteDto;
import org.abdessamadg.backendprogetto.SERVICES.UtenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/*
    In questo file avrò i due controller di tipo (POST) REST: uno per il login e uno per la registrazione.
    Alla fine si restituisce sempre un file JSON con i relativi dati e l'accesso (garantito o meno) dell'utente.
*/

@RestController
@RequiredArgsConstructor
public class AutenticazioneController {
    private final UtenteService utenteService;
    private final UserAuthProvider userAuthProvider;

    @PostMapping("/login")
    public ResponseEntity<UtenteDto> login(@RequestBody CredenzialiDto  credenzialiDto){
        UtenteDto utente = utenteService .login(credenzialiDto);
        utente.setToken(userAuthProvider.createToken(utente));
        return ResponseEntity.ok(utente);
    }

    @PostMapping("/registrazione")
    public ResponseEntity<UtenteDto> registrazione(@RequestBody SignUpDto signUpDto){
        UtenteDto utente = utenteService.registrazione(signUpDto);
        utente.setToken(userAuthProvider.createToken(utente));
        return ResponseEntity.created(URI.create("/profilazione" + utente.getCodiceFiscale())).body(utente);
    }
}
