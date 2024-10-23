package com.web.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	//"name"으로 시작하는 user를 검색, 오름차순으로 정렬
	List<User> findByNameStartingWithOrderById(String name);

	//id가 "id"이고 password가 "password"인 사람을 검색
	User findByIdAndPassword(String id, String password);

	//name이 null이 아닌 user를 검색, 내림차순으로 정렬
	List<User> findByNameIsNotNullOrderById();
}
