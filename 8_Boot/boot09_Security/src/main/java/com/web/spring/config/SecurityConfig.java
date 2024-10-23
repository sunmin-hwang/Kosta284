package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	//인증관련 설정은...SecurityFilterChain
	//SecurityFilterChain을 빈으로 지정..
	//members/...인증여부
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		//여기다가 http 요청에 대한 인증과 권한관련 정책을 등록..7버전 부터는 모든 코드를 람다현식으로 작성하도록 규정..
		http
			.authorizeHttpRequests(auth->auth.anyRequest().authenticated())//어떤 요청에도 인증받겠다
			.formLogin(Customizer.withDefaults());//디폴트 방식인 로그인폼으로 인증받겠다
		return http.build();
	}
	
	//UserDetailsService빈을 등록하고..디비 연결했다 치고..id, password 정보를 InMemory
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("security")
								.password("{noop}7777")
								.roles("USER")
								.build();
		UserDetails user1 = User.withUsername("security1")
							   .password("{noop}7777")
							   .roles("USER")
							   .build();
		UserDetails user2 = User.withUsername("security2")
								.password("{noop}7777")
								.roles("USER")
								.build();
		return new InMemoryUserDetailsManager(user, user1, user2);
	}
}
