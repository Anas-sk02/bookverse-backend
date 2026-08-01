package com.bookverse.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
 // abhi shirf testing wagera ke liye yahi allow rakhe hai APi ke liye
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/auth/**",  //login ki jarurat nhi iske liyee
                                "/swagger-ui/**",  //Swagger bhi open.
                                "/v3/api-docs/**"
                        ).permitAll()

                        .anyRequest().authenticated()    //baki saari Api ke liye login compulsory
                )

                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
