package org.abdessamadg.backendprogetto.REPOSITORIES;

import org.abdessamadg.backendprogetto.MODELS.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, String> {

    Optional<Utente> findByCodiceFiscale(String codiceFiscale);
}
