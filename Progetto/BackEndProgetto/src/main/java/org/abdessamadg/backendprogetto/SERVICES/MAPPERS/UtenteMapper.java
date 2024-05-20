package org.abdessamadg.backendprogetto.SERVICES.MAPPERS;

import org.abdessamadg.backendprogetto.MODELS.Utente;
import org.abdessamadg.backendprogetto.SERVICES.DTO.SignUpDto;
import org.abdessamadg.backendprogetto.SERVICES.DTO.UtenteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/*
    E' un'interfaccia mapper che serve per definire le regole di mapping tra gli oggetti:
    Utente, SignUpDto e UtenteDto.

    Sto utilizzando la libreria MapStruct per generare automaticamente le implementazioni ei metodi di mapping.
*/

@Mapper(componentModel = "spring")
public interface UtenteMapper {

    UtenteDto toUtenteDto(Utente utente);

    @Mapping(target = "password", ignore = true)
    Utente signUpToUser(SignUpDto signUpDto);
}
