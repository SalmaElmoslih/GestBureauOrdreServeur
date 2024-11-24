package com.serveur.serveurGestBureauOrdre.Controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Remplacez par votre chemin d'API
                .allowedOrigins("http://localhost:4200") // Permet l'accès à partir de votre frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes HTTP autorisées
                .allowedHeaders("*") // Autoriser tous les headers
                .allowCredentials(true); // Permet l'envoi des cookies
    }
}

