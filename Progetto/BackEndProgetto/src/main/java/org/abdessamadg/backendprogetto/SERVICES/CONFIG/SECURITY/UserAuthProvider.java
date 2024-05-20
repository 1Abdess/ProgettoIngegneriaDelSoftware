package org.abdessamadg.backendprogetto.SERVICES.CONFIG.SECURITY;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.abdessamadg.backendprogetto.SERVICES.DTO.UtenteDto;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {
    @Value("${security.jwt.token.secret-key:secret-key}")
    private String chiaveSegreta;


    //Inizializzo la chiave segreta per la firma del token utilizzando l'algoritmo HMAC256 e codifica in Base64.
    @PostConstruct
    protected void init(){
        chiaveSegreta = Base64.getEncoder().encodeToString(chiaveSegreta.getBytes());
    }


    //Creo un nuovo token JWT con i dati forniti dall'oggetto UtenteDto
    public String createToken(UtenteDto utenteDto) {
        //Voglio che il token sia valido per 1 ora
        Date oraCreazioneToken = new Date();
        Date validitaToken = new Date(oraCreazioneToken.getTime() + 3600000);

        Algorithm algorithm = Algorithm.HMAC256(chiaveSegreta);
        return JWT.create()
                .withSubject(utenteDto.getCodiceFiscale())
                .withIssuedAt(oraCreazioneToken)
                .withExpiresAt(validitaToken)
                .withClaim("nome", utenteDto.getNome())
                .withClaim("cognome", utenteDto.getCognome())
                .sign(algorithm);
    }


    //Verifica la validità di un token JWT ricevuto e restituisce un'istanza di autenticazione Spring Security
    // contenente le informazioni dell'utente estratte dal token
    public Authentication validazioneToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(chiaveSegreta);
        JWTVerifier verifier = JWT.require(algorithm)
                .build();
        DecodedJWT decoded = verifier.verify(token);

        UtenteDto utente = UtenteDto.builder()
                .codiceFiscale(decoded.getSubject())
                .nome(decoded.getClaim("nome").asString())
                .cognome(decoded.getClaim("cognome").asString())
                .build();

        return new UsernamePasswordAuthenticationToken(utente, null, Collections.emptyList());
    }
}
