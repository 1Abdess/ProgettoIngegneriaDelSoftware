package org.abdessamadg.backendprogetto.SERVICES.CONFIG;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
    Fornisco na configurazione per la codifica delle password all'interno della mia app
*/

@Component
public class PasswordConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}