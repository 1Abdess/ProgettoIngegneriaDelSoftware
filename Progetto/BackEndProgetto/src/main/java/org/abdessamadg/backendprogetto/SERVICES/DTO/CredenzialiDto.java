package org.abdessamadg.backendprogetto.SERVICES.DTO;

/*
    Utilizzo un record di java per rappresentare le credenziali dell'utente al momento del login.
*/

public record CredenzialiDto (String codiceFiscale, String password) {
}
