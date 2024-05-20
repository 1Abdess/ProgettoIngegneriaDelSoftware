package org.abdessamadg.backendprogetto.SERVICES.CONFIG.SECURITY;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*
    Sto implementando un filtro che controlla le richieste HTTP per token JWT.
    Quando una richiesta HTTP arriva al server, questo filtro controlla se contiene un token JWT
    nell'intestazione di autorizzazione.
    Se sì, il filtro verifica la validità del token utilizzando un'istanza di UserAuthProvider.
    Se il token è valido, imposta l'autenticazione nel contesto di sicurezza di Spring.
*/

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final UserAuthProvider userAuthProvider;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    )
            throws ServletException, IOException
    {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header != null) {
            String[] authElements = header.split(" ");

            if (authElements.length == 2 && "Bearer".equals(authElements[0])) {
                try {
                    if ("GET".equals(request.getMethod())) {
                        SecurityContextHolder.getContext().setAuthentication(
                                userAuthProvider.validazioneToken(authElements[1]));
                    } else {
                        SecurityContextHolder.getContext().setAuthentication(
                                userAuthProvider.validazioneToken(authElements[1]));
                    }
                } catch (RuntimeException e) {
                    SecurityContextHolder.clearContext();
                    throw e;
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}