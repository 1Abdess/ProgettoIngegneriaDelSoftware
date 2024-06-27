package org.abdessamadg.backendprogetto.SERVICES;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.abdessamadg.backendprogetto.MODELS.Utente;
import org.abdessamadg.backendprogetto.REPOSITORIES.UtenteRepository;
import org.abdessamadg.backendprogetto.SERVICES.DTO.CredenzialiDto;
import org.abdessamadg.backendprogetto.SERVICES.DTO.SignUpDto;
import org.abdessamadg.backendprogetto.SERVICES.DTO.UtenteDto;
import org.abdessamadg.backendprogetto.SERVICES.EXCEPTIONS.AppException;
import org.abdessamadg.backendprogetto.SERVICES.MAPPERS.UtenteMapper;

import java.util.Optional;

/*
    Di nuovo, lombok mi aiuta a velocizzare il processo di sviluppo del codice
*/

@Service
@RequiredArgsConstructor
public class UtenteService {

    private final UtenteRepository utenteRepository;
    private final PasswordEncoder passwordEncoder;
    private final UtenteMapper utenteMapper;


    // Sto prendendo in input le credenziali dell'utente e verifico se corrispondono a un utente nel database.
    // Se sì, restituisco un oggetto UtenteDto che rappresenta l'utente autenticato.
    // Se le credenziali non sono valide: viene sollevata un'eccezione AppException con stato.
    public UtenteDto login(CredenzialiDto credenzialiDto){

        Utente utente = utenteRepository.findByCodiceFiscale(credenzialiDto.codiceFiscale())
                .orElseThrow(() -> new AppException("Codice Fiscale Non Riconosciuto", HttpStatus.NOT_FOUND));
        if (passwordEncoder.matches(credenzialiDto.password(), utente.getPassword())) {
            return utenteMapper.toUtenteDto(utente);
        }

        throw new AppException("Password Non Corretta.", HttpStatus.BAD_REQUEST);
    }

    // Sto gestendo il processo di registrazione di un nuovo utente.
    // Controllo se il codice fiscale è già presente nel database e, se non lo è, crea un nuovo utente
    // utilizzando i dati forniti nel DTO SignUpDto.
    public UtenteDto registrazione(SignUpDto signUpDto) {
        Optional<Utente> oUser = utenteRepository.findByCodiceFiscale(signUpDto.codiceFiscale());
        if(oUser.isPresent()){
            throw new AppException("Codice Fiscale Già Esistente.", HttpStatus.BAD_REQUEST);
        }

        Utente utente = utenteMapper.signUpToUser(signUpDto);

        utente.setPassword(passwordEncoder.encode(signUpDto.password()));
        Utente utenteSalvato = utenteRepository.save(utente);
        return utenteMapper.toUtenteDto(utenteSalvato);
    }


    // Sto recuperando un utente dal database utilizzando il suo codice fiscale.
    // Se l'utente viene trovato, viene restituito un oggetto UtenteDto che lo rappresenta.
    //Se l'utente non esiste nel database, viene restituito null.
    public UtenteDto getUtenteByCodiceFiscale(String codiceFiscale) {
        Optional<Utente> optionalUtente = utenteRepository.findByCodiceFiscale(codiceFiscale);

        if (optionalUtente.isPresent()) {
            Utente utente = optionalUtente.get();
            return utenteMapper.toUtenteDto(utente);
        }
        else {
            return null;
        }
    }

    // Aggiornamento dell'utente
    public UtenteDto aggiornaUtente(UtenteDto utenteDto) {
        Optional<Utente> optionalUtente = utenteRepository.findByCodiceFiscale(utenteDto.getCodiceFiscale());
        if (optionalUtente.isPresent()) {
            Utente utente = optionalUtente.get();
            utente.setNome(utenteDto.getNome());
            utente.setCognome(utenteDto.getCognome());
            utente.setOrganizzazione(utenteDto.getOrganizzazione());
            utente.setCategoria(utenteDto.getCategoria());
            utente.setUrlFotoProfilo(utenteDto.getUrlFotoProfilo());

            utenteRepository.save(utente);
            return utenteMapper.toUtenteDto(utente);
        }
        throw new AppException("Utente non trovato", HttpStatus.NOT_FOUND);
    }
}