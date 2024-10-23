package com.web.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Product;



@RestController
@RequestMapping("/api/v1")
public class TestController {
	@GetMapping("/product")
	public ResponseEntity<?> getProductByParam(int no) {
		Product p = new Product(no, "사과", 5000);
		return ResponseEntity.status(200).body(p);
	}
	
	@GetMapping("/product/{no}")
	public ResponseEntity<?> getProductByUrl(@PathVariable int no) {
		Product p = new Product(no, "배", 3000);
		return ResponseEntity.status(200).body(p);
	}
	
	@GetMapping("/products")
	public ResponseEntity<?> getAllProduct() {
		List<Product> list = new ArrayList<>();
		list.add(new Product(1, "사과", 5000));
		list.add(new Product(2, "바나나", 7000));
		list.add(new Product(3, "배", 6000));
		
		return ResponseEntity.status(200).body(list);
	}
	
	@PostMapping("/product")
	public ResponseEntity<?> insertProduct(@RequestBody Product product) {
		return ResponseEntity.status(201).body(product + " insert OK!!");
	}
	
	@PutMapping("/product")
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {
		return ResponseEntity.status(202).body(product + "update OK!!");
	}
	
	@DeleteMapping("/product/{no}")
	public ResponseEntity<?> deleteProduct(@PathVariable int no) {
		return ResponseEntity.status(200).body(no + " delete OK!!");
	}
}
