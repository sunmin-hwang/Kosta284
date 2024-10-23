package com.web.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller //SSR
@RestController //CSR...데이터만 클라이언트로 리턴하는 컨트롤러
public class HelloController {
	
	@GetMapping("/")
	public String index() {
		System.out.println("Hello Spring boot~~!!");
		return "Hello Index!!";
	}
	
	@GetMapping("hello")
	public String hello() {
		return "Hello~~ SpringBoot~~!!";
	}
	
}
