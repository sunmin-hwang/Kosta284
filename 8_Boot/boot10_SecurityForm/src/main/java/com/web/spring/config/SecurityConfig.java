package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("SecurityFilterChain=======================");
		http
        	.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())//어떤 요청에도 무조건 인증받도록
        	//.formLogin(Customizer.withDefaults());//폼 로그인 방식으로 인증받겠다.
        	.formLogin(form->form
        					 //.loginPage("/loginPage")//주석 -- Security가 제공하는 폼 사용
        					 .loginProcessingUrl("/loginProc")
        					 .usernameParameter("userId")//security에서 id는 userName
        					 .passwordParameter("userPass")
        					 .defaultSuccessUrl("/", false)//false가 디폴트, true는 항상 사용
        					 .failureUrl("/failed")
        					 .successHandler((request,response,authentication)->{
        						 response.sendRedirect("/home");//성공하면 home으로..
        					 })
        					 .failureHandler((request,response, exception)->{        						 
        						 response.sendRedirect("/login");//실패하면 login으로..
        					 })
        					 .permitAll()
        			   );
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		log.info("UserDetailsService=======================");
		UserDetails user = User.withUsername("kosta")
								.password("{noop}1234")
								.roles("USER")//ROLE_ 자동으로 붙는다.
								.build();
		log.info("UserDetailsService=======================>user :: {}", user);
		return new InMemoryUserDetailsManager(user);
	}
}
