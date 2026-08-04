package com.bookverse.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                "/auth/**",
//                                "/swagger-ui/**",
//                                "/v3/api-docs/**"
//                        ).permitAll()
//
//                        .anyRequest().authenticated()
//                )

                .authorizeHttpRequests(auth -> auth

                        // Public APIs
                        .requestMatchers(
                                "/auth/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()

                        // USER + ADMIN
                        .requestMatchers(HttpMethod.GET, "/books/**")
                        .hasAnyRole("USER", "ADMIN")

                        .requestMatchers(HttpMethod.GET, "/authors/**")
                        .hasAnyRole("USER", "ADMIN")

                        .requestMatchers(HttpMethod.GET, "/categories/**")
                        .hasAnyRole("USER", "ADMIN")

                        // ADMIN Only
                        .requestMatchers(HttpMethod.POST, "/books/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST,"/books/*/cover")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/books/*/pdf")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/books/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE, "/books/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/authors/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/authors/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE, "/authors/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/categories/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/categories/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE, "/categories/**")
                        .hasRole("ADMIN")

                        .anyRequest()
                        .authenticated()
                )

                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
