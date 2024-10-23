package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	log.info("SecurityFilterChain======================>");
    	
    	http
    		.csrf((auth)->auth.disable())
    		.formLogin((auth)->auth.disable())
    		.httpBasic((auth)->auth.disable())
    		.authorizeHttpRequests((auth) -> auth
    										 .requestMatchers("/index", "/members", "/members/**", "/boards").permitAll()
    										 .requestMatchers("/admin").hasRole("ADMIN")
    										 .anyRequest().authenticated());
		return http.build();
	}
    
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
    	log.info("BCryptPasswordEncoder call..============>");
    	return new BCryptPasswordEncoder();
    }
}
