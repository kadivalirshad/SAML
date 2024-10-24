package com.inextue.saml_sp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/saml/**", "/login", "/error").permitAll()
                        .anyRequest().authenticated())
                .saml2Login(saml2 -> saml2
                        .defaultSuccessUrl("/home")
                        .failureUrl("/login?error"));
        return http.build();
    }
}

