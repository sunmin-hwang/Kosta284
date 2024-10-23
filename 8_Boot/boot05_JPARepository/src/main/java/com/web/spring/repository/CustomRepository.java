package com.web.spring.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Custom;

/*
 * Spring Data JPA Repository...이전의 DAO와 같은 역할
 * 인터페이스가 나오면 해당 인터페이스를 구현한 실체 클래스를 다시 상속받아서 작성해야하지만
 * Spring Data JPA 기술은 인터페이스를 구현하는 빈 클래스를 자동으로 생성시켜준다
 * */
public interface CustomRepository extends JpaRepository<Custom, Integer>{
	//아무것도 작성 안해도 기본적인 CRUD가 다 들어있다...
	// JPA Query Method...추가
	/*
	  JPA Query Method
	  1. 대부분 findBy로 시작
	  2. 이름 규칙만 잘 정해주면 자동으로 SQL 구문이 실행
	  3. ORM 방식이기 때문에 함수명은 CamelCase가 기본이다.
	*/
	
	Optional<List<Custom>> findByName(String name);
	
	//findByLastnameAndFirstname
	Optional<Custom> findByNameAndEmail(String name, String email);	
	
	//findByLastnameOrFirstname
	List<Custom> findByNameOrEmail(String name, String email);
	
	//고객의 id값이 1~3 사이의 아이디를 가지는 고객을 검색
	Optional<List<Custom>> findByCustomIdBetween(Integer minCustomId, Integer maxCustomId);
	
	//고객의 id가 3보다 작은 아이디를 가지는 고객을 검색
	Optional<List<Custom>> findByCustomIdLessThan(Integer CustomId);

	//고객의 등록일자가 어제 이후로 등록한 고객을 검색
	Optional<List<Custom>> findByRegDateAfter(LocalDateTime date);

	//고객의 등록일자가 어제 이전에 등록한 고객을 검색
	Optional<List<Custom>> findByRegDateBefore(LocalDateTime date);

	//고객의 이름이 null값인 고객을 검색
	List<Custom> findByNameIsNull();
	List<Custom> findByNameIsNotNull();

	// SELECT custom_id, password, name, email, redDate FROM custom WHERE name LIKE ?
	List<Custom> findByNameLike(String name);//와일드카드 적용 안됨, 값에다 %, _를 지정해야한다.

	// SELECT custom_id, password, name, email, redDate FROM custom WHERE name LIKE "%종각"
	List<Custom> findByNameEndingWith(String name);// 와일드카드 적용됨

	// 정렬
	List<Custom> findByOrderByCustomIdDesc();
	List<Custom> findByOrderByCustomId();
	
	//고객 아이디가 3보다 큰 아이디를 가지는 고객을 검색 + 아이디를 내림차순 청렬
	List<Custom> findByCustomIdGreaterThanOrderByCustomIdDesc(Integer CustomId);
	
	//고객 아이디가 1이거나 3이거나 5인 고객을 검색
	List<Custom> findByCustomIdIn(List<Integer> CustomIdList);
	
	//Not은 null과는 비교하지 않는다..null은 출력되지 않는다....!!!
	List<Custom> findByNameNot(String name);
	
}
