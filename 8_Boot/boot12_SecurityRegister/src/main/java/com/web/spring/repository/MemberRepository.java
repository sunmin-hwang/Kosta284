package com.web.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	@Query(value = "SELECT m FROM Member m WHERE m.id = ?1")
	Member duplicateCheck(String id);
	
	Member findById(String id);//id에 해당하는 멤버를 검색...Query method
	
	boolean existsById(String id);//id에 해당하는 멤버의 존재여부 확인
}
