package org.abdessamadg.backend.MODELS;

import jakarta.persistence.*;

/*
   COSA STIO FACENDO?
    Abbiamo usato la JPA (Java Persistance API) per il collegento al DB, dove esso neccessica di un
    ORM (Object Relational Mapping) per essere implementato.
*/

@Table
@Entity(name = "UTENTE")
public class Utente {
    @Id
    @Column(name = "CF", length = 16, updatable = false)
    private String codiceFiscale;

    @Column(name = "NOME", length = 32)
    private String nome;

    @Column(name = "COGNOME", length = 32)
    private String cognome;

    @Column(name = "EMAIL", length = 64)
    private String email;

    @Column(name = "PASS", length = 128)
    private String password;

    @Column(name = "ORG", length = 64)
    private String organizzazione;

    @Column(name = "CATEGORIA", length = 64)
    private String categoria;

    //ho preso come lunghezza massima 1028 caratteri perchè è il masimo su Google Chrome
    @Column(name = "URL_FOTO_PROFILO", length = 1024)
    private String urlFotoProfilo;

    //COSTRUTTORE
    public Utente(String codiceFiscale, String nome, String cognome, String email, String password, String organizzazione, String categoria, String urlFotoProfilo) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.organizzazione = organizzazione;
        this.categoria = categoria;
        this.urlFotoProfilo = urlFotoProfilo;
    }
    public Utente() {
    }

    //GETTER
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getOrganizzazione() {
        return organizzazione;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    //SETTER
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setOrganizzazione(String organizzazione) {
        this.organizzazione = organizzazione;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }
}