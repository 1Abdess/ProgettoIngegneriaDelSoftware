package org.abdessamadg.backendprogetto.SERVICES.EXCEPTIONS;

import org.abdessamadg.backendprogetto.SERVICES.DTO.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException appException){
        return ResponseEntity.status(appException.getHttpStatus())
                .body(new ErrorDto(appException.getMessage()));
    }
}
