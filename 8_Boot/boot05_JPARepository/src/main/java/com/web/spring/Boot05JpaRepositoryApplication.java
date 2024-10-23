package com.web.spring;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.Custom;
import com.web.spring.repository.CustomRepository;

import jakarta.transaction.Transactional;

//CustomRepository를 주입..Spring Data JPA가 생성하는 빈을 여기서 가져다 쓴다...
@SpringBootApplication
public class Boot05JpaRepositoryApplication implements CommandLineRunner{
	
	//주입된 해당 빈을 사용해서 CRUD작업을 다 할 수 있다.
	//트랜잭션 단위로..Entity Manager가 내부적으로 모든 일을 처리할 것이다.
	@Autowired
	private CustomRepository customRepository;
	
	@Override
	@Transactional //jpa메소드가 호출될 때 트랜잭션이 실행되고, 메소드가 종료될 때 트랜잭션이 끝난다.
	public void run(String... args) throws Exception {
		/*
		Optional<Custom> ot = customRepository.findById(1);
		System.out.println(ot);
		*/
		
		/*
		Custom c = customRepository.findById(1).orElseThrow();
		System.out.println(c);
		*/
		
		// CustomRepository를 실제로 구현하고 있는 구현체를 출력
		/*
		 jdk.proxy7.$Proxy132
		 ::
		 Proxy는 인터페이스를 구현하고 있는 객체를 동적으로 생성해주는 자바 기술
		 모든 자바 프레임워크 구현체들은 Proxy 기술을 이용해서 만들어진다.
		 */
		//System.out.println(customRepository.getClass().getName());
		
		//새로운 Custom을 추가
		/*
		Custom c1 = new Custom();
		c1.setName("James");
		c1.setEmail("jas@naver.com");
		c1.setPassword("2222");
		c1.setRegDate(LocalDateTime.now());
		
		customRepository.save(c1);
		*/
		
		//방금 추가한 사람을 삭제
		//customRepository.deleteById(6);
		
		/*
		Custom deleteC = customRepository.findById(4).orElseThrow();
		customRepository.delete(deleteC);
		*/
		
		//수정하기...update 함수는 따로 제공되지 않는다.
		// Entity정보와 스냅샷 정보가 다를 때 트랜잭션이 완료되는 시점에 이걸 감지하고 update가 자동으로 호출
		/*
		Custom updateC = customRepository.findById(1).orElseThrow();
		System.out.println("Update 하기 전 >> " + updateC);
		
		updateC.setPassword("1234");
		System.out.println("Update 한 후 >> " + updateC);
		*/
		
		//findByNameLike
		/*
		customRepository.findByNameLike("홍%").forEach(c->System.out.println(c));
		
		customRepository.findByNameEndingWith("종각").forEach(c->System.out.println(c));
		*/
		
		//findByNameNot
		customRepository.findByNameNot("김종각").forEach(c->System.out.println(c));
		
		System.out.println("--------------------------------------------------------");
		
		customRepository.findByCustomIdIn(List.of(1, 2, 10)).forEach(c->System.out.println(c));
	}

	public static void main(String[] args) {
		SpringApplication.run(Boot05JpaRepositoryApplication.class, args);
	}


}
