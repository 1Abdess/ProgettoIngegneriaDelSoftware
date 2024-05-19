package org.abdessamadg.backendprogetto.SERVICES.MAPPERS;

import org.abdessamadg.backendprogetto.MODELS.Utente;
import org.abdessamadg.backendprogetto.SERVICES.DTO.SignUpDto;
import org.abdessamadg.backendprogetto.SERVICES.DTO.UtenteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtenteMapper {

    UtenteDto toUtenteDto(Utente utente);

    @Mapping(target = "password", ignore = true)
    Utente signUpToUser(SignUpDto signUpDto);
}
