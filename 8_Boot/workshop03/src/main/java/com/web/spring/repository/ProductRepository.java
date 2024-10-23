package com.web.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Long countBy();
	Optional<List<Product>> findFirst2ByOrderByProNo();
}
