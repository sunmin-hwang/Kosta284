package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.User;
import com.web.spring.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Workshop02Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/*
		User user = new User();
		user.setId("kosta");
		user.setPassword("1234");
		user.setName("코스타");
		
		userRepository.save(user);
		*/
		
		/*
		User user = userRepository.findById("kosta").orElseThrow();
		
		System.out.println(user);
		*/
		
		//userRepository.findAll().forEach(c->System.out.println(c));
		
		/*
		user.setName("kosta");
		System.out.println(user);
		*/
		
		//userRepository.delete(user);
		
		//userRepository.findByNameStartingWithOrderById("코").forEach(c->System.out.println(c));
		
		//System.out.println(userRepository.findByIdAndPassword("kosta", "1234"));
		
		//userRepository.findByNameIsNotNullOrderById().forEach(c->System.out.println(c));
	}

	public static void main(String[] args) {
		SpringApplication.run(Workshop02Application.class, args);
	}


}
