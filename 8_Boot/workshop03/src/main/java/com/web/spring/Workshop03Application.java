package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.repository.ProductRepository;
import com.web.spring.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Workshop03Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// LAZY 일때는 select 1번, EAGER일때는 3번 실행 -- LAZY 사용
		//userRepository.findAll().forEach(u->System.out.println(u));
		
		// LAZY와 EAGER 둘 다 select 3번 실행
		// EAGER는 처음에 Product 까지 한번에 가져옴
		// LAZY는 getProducts()가 실행될 때 Product를 하나씩 가져옴
		/*
		userRepository.findAll().forEach(u->{
			System.out.println(u);
			System.out.println(u.getProducts());
		});
		*/
		
		// 둘 다 select 한번 실행하지만 EAGER는 left join 사용해 Product까지 한번에 가져옴
		//User user = userRepository.findById(1).orElseThrow();
		//System.out.println(user);
		
		// EAGER는 미리 Product까지 가져와서 바로 출력해주지만 LAZY는 select로 다시 Product 가져옴 -- EAGER 사용
		//System.out.println(user.getProducts());
		
		/*
		Long count = productRepository.countBy();
		System.out.println(count);
		*/
		
		//productRepository.findFirst2ByOrderByProNo().orElseThrow().forEach(p->System.out.println(p));
	}
	public static void main(String[] args) {
		SpringApplication.run(Workshop03Application.class, args);
	}


}
