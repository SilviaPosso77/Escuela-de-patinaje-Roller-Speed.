package com.rollerspeed.v1.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
     @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
        .csrf(config -> config.disable())
        .authorizeHttpRequests( auth->{
            auth.requestMatchers("/Nosotros/**").permitAll();
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/estudiantes/registro").permitAll(); // Permitir GET sin autenticación
            auth.requestMatchers(HttpMethod.POST, "/estudiantes/registro").permitAll();            
            auth.requestMatchers(HttpMethod.GET,"/horarios/estudiantes").permitAll();
            auth.requestMatchers(HttpMethod.POST,"/horarios/estudiantes").permitAll();
            auth.requestMatchers(HttpMethod.GET,"/horarios/profesores").permitAll();
            auth.requestMatchers(HttpMethod.POST,"/horarios/profesores").permitAll();

            auth.requestMatchers(HttpMethod.GET,"/clases/editar/{id}").hasAnyRole("ADMIN", "PROFESOR");
            auth.requestMatchers(HttpMethod.POST,"/clases/{id}").hasAnyRole("ADMIN", "PROFESOR");
            auth.requestMatchers("/clases/registro").hasRole("ADMIN");
            auth.requestMatchers("/profesores/registro").hasRole("ADMIN");

            auth.anyRequest().authenticated();
        })
        .formLogin(Customizer.withDefaults())   
        .build();
     }

}
