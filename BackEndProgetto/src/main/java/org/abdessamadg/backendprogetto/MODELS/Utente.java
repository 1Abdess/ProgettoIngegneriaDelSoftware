package org.abdessamadg.backendprogetto.MODELS;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "UTENTE")
public class Utente {
    @Id
    @Column(name = "CF", length = 16, updatable = false)
    private String codiceFiscale;

    @Column(name = "NOME", length = 32, nullable = false)
    private String nome;

    @Column(name = "COGNOME", length = 32, nullable = false)
    private String cognome;

    @Column(name = "EMAIL", length = 64, nullable = false)
    private String email;

    @Column(name = "PASS", length = 128, nullable = false)
    private String password;

    @Column(name = "ORG", length = 64)
    private String organizzazione;

    @Column(name = "CATEGORIA", length = 64)
    private String categoria;

    //ho preso come lunghezza massima 1028 caratteri perchè è il masimo su Google Chrome
    @Column(name = "URL_FOTO_PROFILO", length = 1024)
    private String urlFotoProfilo;
}
