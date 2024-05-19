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

@Service
@RequiredArgsConstructor
public class UtenteService {
    private final UtenteRepository utenteRepository;
    private final PasswordEncoder passwordEncoder;
    private final UtenteMapper utenteMapper;

    public UtenteDto login(CredenzialiDto credenzialiDto){

        Utente utente = utenteRepository.findByCodiceFiscale(credenzialiDto.codiceFiscale())
                .orElseThrow(() -> new AppException("Codice Fiscale Non Riconosciuto", HttpStatus.NOT_FOUND));
        if (passwordEncoder.matches(credenzialiDto.password(), utente.getPassword())) {
            return utenteMapper.toUtenteDto(utente);
        }

        throw new AppException("Password Non Corretta.", HttpStatus.BAD_REQUEST);
    }

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
}
