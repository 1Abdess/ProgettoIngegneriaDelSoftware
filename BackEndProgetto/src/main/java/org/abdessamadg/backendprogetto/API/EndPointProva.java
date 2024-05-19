package org.abdessamadg.backendprogetto.API;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EndPointProva {
    @GetMapping("/ciao")
    public ResponseEntity<List<String>> get() {
        return ResponseEntity.ok(Arrays.asList("ciao!"));
    }

}
