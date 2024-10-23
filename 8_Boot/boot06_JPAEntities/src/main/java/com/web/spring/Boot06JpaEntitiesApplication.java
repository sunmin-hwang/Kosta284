package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.Board;
import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.CustomRepository;
import com.web.spring.repository.RoleRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Boot06JpaEntitiesApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CustomRepository customRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/*
		roleRepository.findAll().forEach(r->System.out.println(r));
		*/
		
		//customRepository.findAll().forEach(c->System.out.println(c));
		
		/*
		 findAll() --> select * from custom; //한번의 쿼리로 전체 Custom을 받아온다
		 c.getRoles() --> select * from custom_role join role where custom_id=?
		 
		 이런 문제 상황을 우리는 N + 1 문제라 한다.
		 만약에 Custom 레코드가 수가 많다면 심각한 성능 저하에 빠진다.
		 
		 연관관계가 설정된 엔티티를 조회할 경우, findAll, 데이터의 갯수(n)만큼의 조인 select절이 계속적으로 실행된다.
		 
		 Custom --> custom_role --> role 여기 안에 있는 데이터를 한번의 쿼리문으로 받아올 수 없을까?
		 
		 */
		
		/*
		customRepository.findAll().forEach(c->{
			System.out.println(c);
			System.out.println(c.getRoles());
		});
		*/
		
		//findAll 에서는 Board 정보만 받아오고 싶지만 fetchType이 EAGER로 잡혀져있으면 Custom이 함께 나온다...LAZY로 변경
		//boardRepository.findAll().forEach(b->System.out.println(b));
		
		/*
		boardRepository.findAll().forEach(b->{
			System.out.println(b);
			System.out.println(b.getCustom());
			System.out.println("-------------------------------------");
		});
		*/
		
		/*
		 findAll인 경우 - fetchType EAGER, LAZY 방식 모두 다 조인이 안걸린다.
		 findById인 경우 - EAGER 방식에서 left 조인이 걸린다.
		 
		 전체검색 / 한 건 검색이 서로 다르게 동작한다.
		 
		 엔티티가 결합된 관계에서 굳이 함께 가져와야 하는 필요가 없는경우!!!
		 LAZY 방식으로 가져온다.
		 반면에 데이터를 함께 가져와야 하는 경우(게시판 글정보와 함께 글쓴이 정보)일때는
		 특히 한 건의 데이터를 직접적으로 받아와야하는 경우에는 EAGER
		 */
		Board b = boardRepository.findById(1L).orElseThrow();
		System.out.println(b);
		System.out.println(b.getCustom());
	}

	public static void main(String[] args) {
		SpringApplication.run(Boot06JpaEntitiesApplication.class, args);
	}


}
