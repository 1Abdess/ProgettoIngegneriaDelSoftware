package org.abdessamadg.backendprogetto.SERVICES.MAPPERS;

import javax.annotation.processing.Generated;
import org.abdessamadg.backendprogetto.MODELS.Utente;
import org.abdessamadg.backendprogetto.SERVICES.DTO.SignUpDto;
import org.abdessamadg.backendprogetto.SERVICES.DTO.UtenteDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-19T14:27:43+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UtenteMapperImpl implements UtenteMapper {

    @Override
    public UtenteDto toUtenteDto(Utente utente) {
        if ( utente == null ) {
            return null;
        }

        UtenteDto.UtenteDtoBuilder utenteDto = UtenteDto.builder();

        utenteDto.codiceFiscale( utente.getCodiceFiscale() );
        utenteDto.password( utente.getPassword() );
        utenteDto.nome( utente.getNome() );
        utenteDto.cognome( utente.getCognome() );
        utenteDto.email( utente.getEmail() );
        utenteDto.organizzazione( utente.getOrganizzazione() );
        utenteDto.categoria( utente.getCategoria() );
        utenteDto.urlFotoProfilo( utente.getUrlFotoProfilo() );

        return utenteDto.build();
    }

    @Override
    public Utente signUpToUser(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        Utente.UtenteBuilder utente = Utente.builder();

        utente.codiceFiscale( signUpDto.codiceFiscale() );
        utente.nome( signUpDto.nome() );
        utente.cognome( signUpDto.cognome() );
        utente.email( signUpDto.email() );
        utente.organizzazione( signUpDto.organizzazione() );
        utente.categoria( signUpDto.categoria() );
        utente.urlFotoProfilo( signUpDto.urlFotoProfilo() );

        return utente.build();
    }
}
