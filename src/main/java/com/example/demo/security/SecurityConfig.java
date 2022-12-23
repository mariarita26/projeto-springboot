package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig  {
    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable().authorizeHttpRequests((request) -> {
            try {
                request.requestMatchers("/pessoa", "/pessoa/**")
                        .permitAll()
                        .and()
                        .httpBasic();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).build();
    }

}
