package org.abdessamadg.backendprogetto.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiProva {
    @GetMapping("/prova")
    public String prova(){
        return "Axios funziona";
    }
}
