

 package com.rollerspeed.v1.Config;

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.web.SecurityFilterChain;

 @Configuration
 @EnableWebSecurity
 public class SecurityConfig {

    

     @Bean
     public BCryptPasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
             .authorizeHttpRequests(auth -> auth
                 .requestMatchers("/", "/auth/**", "/public/**", "/css/**", "/js/**", "/Bootstrap/**").permitAll()
                 .anyRequest().authenticated()
             )
             .formLogin(form -> form
                 .loginPage("/auth/login")
                 .defaultSuccessUrl("/private/index", true)
                 .failureUrl("/auth/login?error=true")
                 .loginProcessingUrl("/auth/login-post")
                 .permitAll()
             )
             .logout(logout -> logout
                 .logoutUrl("/logout")
                 .logoutSuccessUrl("/public/index")
                 .permitAll()
             );
        
         return http.build();
     }
 }