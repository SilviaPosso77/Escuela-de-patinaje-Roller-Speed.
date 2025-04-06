package com.rollerspeed.v1.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
     @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
        .csrf(config -> config.disable())
        .authorizeHttpRequests( auth->{
            auth.requestMatchers("/clases/registro").hasRole("ADMIN");

            auth.requestMatchers("/Nosotros/**").permitAll();
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers("/estudiantes/registro").permitAll();
            auth.requestMatchers("/horarios/estudiantes").permitAll();

            auth.anyRequest().authenticated();

            
        })
        .httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults())   
        .build();
     }

     @Bean
     public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("Admin").password("123").roles("ADMIN").build());
        return manager;
     }
}
