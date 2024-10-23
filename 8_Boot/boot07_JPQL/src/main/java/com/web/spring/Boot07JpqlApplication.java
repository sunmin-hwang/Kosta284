package com.web.spring;

import java.time.LocalDateTime;import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.entity.Board;
import com.web.spring.entity.Custom;
import com.web.spring.entity.Role;
import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.CustomRepository;
import com.web.spring.repository.RoleRepository;


@SpringBootApplication
public class Boot07JpqlApplication implements CommandLineRunner {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CustomRepository customRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/*
		boardRepository.findAll().forEach(b->{
			System.out.println(b);
			System.out.println(b.getCustom());
		});
		*/
		
		/*
		boardRepository.getBoards().forEach(b->{
			System.out.println(b);
			System.out.println(b.getCustom());
		});
		*/
		
		/*
		Long boardCount = boardRepository.getBoardCount();
		System.out.println("전체 게시글의 갯수 ==> " + boardCount);
		*/
		
		/*
		Role role = roleRepository.findById(2).get();
		System.out.println("Role ==> " + role);
		
		Custom c = new Custom();
		c.setName("한강");
		c.setEmail("han@hmail.net");
		c.setPassword("7777");
		c.setRegDate(LocalDateTime.now());
		c.setRoles(Set.of(role));
		
		customRepository.save(c);
		*/
		
		/*
		Custom c = customRepository.findById(4).get();
		Board b = new Board();
		b.setCustom(c);
		b.setTitle("관리자 권한 작성");
		b.setContent("노베베베르 솽");
		b.setRegDate(LocalDateTime.now());
		
		boardRepository.save(b);
		*/
		
		/*
		boardRepository.getBoards("ROLE_ADMIN").forEach(b->{
			System.out.println(b);
			System.out.println(b.getCustom());
		});
		*/
		
		/*
		boardRepository.getBoardsNative().forEach(b->{
			System.out.println(b);
			System.out.println(b.getCustom());
		});
		*/
		boardRepository.getBoardsNative2().forEach(b->{
			System.out.println(b.getClass().getName());
			System.out.println(b.getContent());
			System.out.println(b.getTitle());
			System.out.println(b.getCustomId());
			System.out.println(b.getBoardId());
			System.out.println(b.getName());
			System.out.println("---------------------------");
		});
		
	}

	public static void main(String[] args) {
		SpringApplication.run(Boot07JpqlApplication.class, args);
	}

}
