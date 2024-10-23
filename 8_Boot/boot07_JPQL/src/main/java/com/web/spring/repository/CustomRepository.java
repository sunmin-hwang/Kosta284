package com.web.spring.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Custom;

public interface CustomRepository extends JpaRepository<Custom, Integer>{
	
	Optional<List<Custom>> findByName(String name);
	Optional<Custom> findByNameAndEmail(String name, String email);	
	List<Custom> findByNameOrEmail(String name, String email);
	Optional<List<Custom>> findByCustomIdBetween(Integer minCustomId, Integer maxCustomId);
	Optional<List<Custom>> findByCustomIdLessThan(Integer CustomId);
	Optional<List<Custom>> findByRegDateAfter(LocalDateTime date);
	Optional<List<Custom>> findByRegDateBefore(LocalDateTime date);
	List<Custom> findByNameIsNull();
	List<Custom> findByNameIsNotNull();
	List<Custom> findByNameLike(String name);
	List<Custom> findByNameEndingWith(String name);
	List<Custom> findByOrderByCustomIdDesc();
	List<Custom> findByOrderByCustomId();
	List<Custom> findByCustomIdGreaterThanOrderByCustomIdDesc(Integer CustomId);
	List<Custom> findByCustomIdIn(List<Integer> CustomIdList);	
	List<Custom> findByNameNot(String name);
	
}
