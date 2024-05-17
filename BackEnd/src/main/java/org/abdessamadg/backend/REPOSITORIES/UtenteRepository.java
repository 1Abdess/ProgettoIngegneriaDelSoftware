package org.abdessamadg.backend.REPOSITORIES;

import org.abdessamadg.backend.MODELS.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

/*
   COSA STO FACENDO?
   Una repository (in questo caso) in Spring Boot mi permette di usare le operazioni CRUD (create, read, update, delete).
   La repository JpaRepository mi fornisce un'astrazione del livello di persistenza.
*/

public interface UtenteRepository extends JpaRepository<Utente, String> {

}
