package org.abdessamadg.backendprogetto.SERVICES.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtenteDto {
    private String codiceFiscale;
    private String password;
    private String nome;
    private String cognome;
    private String email;
    private String organizzazione;
    private String categoria;
    private String urlFotoProfilo;

    private String token;
}