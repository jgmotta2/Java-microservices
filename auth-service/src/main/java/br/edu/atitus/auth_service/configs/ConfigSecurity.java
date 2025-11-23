package br.edu.atitus.auth_service.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer; // Importação necessária para o .withDefaults()
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigSecurity {

    @Bean
    SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF (necessário para APIs Stateless)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Define como Stateless (sem sessão)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // Libera rotas de autenticação (login/signup)
                        .requestMatchers("/ws**", "/ws/**").authenticated() // Protege rotas /ws
                        .anyRequest().permitAll() // Libera o resto (ajuste conforme necessário)
                )
                .cors(Customizer.withDefaults()); // <--- CORREÇÃO: Habilita a integração do CORS com o Spring Security

        return http.build();
    }

    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // Permite qualquer origem (Frontend React Native, Postman, etc)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Permite os métodos necessários
            }
        };
    }

    @Bean
    PasswordEncoder getpPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}