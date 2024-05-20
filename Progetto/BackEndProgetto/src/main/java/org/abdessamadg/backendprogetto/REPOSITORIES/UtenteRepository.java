package org.abdessamadg.backendprogetto.REPOSITORIES;

import org.abdessamadg.backendprogetto.MODELS.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
    Sto definendo un'interfaccia UtenteRepository che estende la JPARepository.
    Ciò mi permette di collegarmi ad Utente.
    In questo modo riesco a sviluppare metodi di base per operazioni di persistenza come:
    inserimento, aggiornamento, ricerca e eliminazione su un'entità specificata.

    Di base seguo sempre la medologia CRUD(Create, Read, Update, Delte)
*/

public interface UtenteRepository extends JpaRepository<Utente, String> {

    Optional<Utente> findByCodiceFiscale(String codiceFiscale);
}
