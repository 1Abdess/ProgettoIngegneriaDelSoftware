package org.abdessamadg.backendprogetto.SERVICES.DTO;

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
