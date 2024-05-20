package org.abdessamadg.backendprogetto.SERVICES.DTO;

/*
    E' un DTO (Data Transfer Object) che rappresenta i dati necessari per la registrazione di un nuovo utente.
    Utilizzp i record di Java.
*/

public record SignUpDto(
        String codiceFiscale,
        String password,
        String nome,
        String cognome,
        String email,
        String organizzazione,
        String categoria,
        String urlFotoProfilo
) {

}
