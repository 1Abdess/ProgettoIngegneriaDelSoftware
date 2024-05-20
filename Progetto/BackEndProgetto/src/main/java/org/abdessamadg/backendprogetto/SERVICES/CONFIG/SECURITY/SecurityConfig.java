package org.abdessamadg.backendprogetto.SERVICES.CONFIG.SECURITY;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/*
    Sto configurando Spring Security per gestire l'autenticazione tramite tojen JWT.
    Disabilito il controllo CSRF (Cross-Site Request Forgery) ovvero che le richieste non devono includere un token
    CSRF.

    Definisco le regole di autorizzazione per le richieste HTTP.
*/

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserAuthProvider userAuthProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserAuthProvider userAuthProvider) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(new JwtAuthFilter(userAuthProvider), BasicAuthenticationFilter.class)
                .sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request ->
                        request
                                .requestMatchers(HttpMethod.POST, "/login", "/registrazione").permitAll()
                                .requestMatchers(HttpMethod.GET, "/profilazione/**", "/prova").permitAll()
                                .anyRequest().authenticated()
                );

        return http.build();
    }
}
