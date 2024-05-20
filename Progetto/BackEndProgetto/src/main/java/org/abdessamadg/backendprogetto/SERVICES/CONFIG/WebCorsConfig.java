package org.abdessamadg.backendprogetto.SERVICES.CONFIG;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
    Sto configurando il CORS (Cross-Origin Resource Sharing) per il mio front end.
    lascio tutto "aperto" perchè la mia applicazione non ha troppi componenti. mi va bene così.
*/

@Configuration
public class WebCorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600L);
    }
}
