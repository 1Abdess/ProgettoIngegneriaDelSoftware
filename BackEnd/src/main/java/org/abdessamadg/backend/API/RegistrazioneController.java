package org.abdessamadg.backend.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrazioneController {
    @GetMapping("/")
    public String prova(){
        return "ciao, prova";
    }
}
