package com.web.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class IndexController {
	@GetMapping("/")
	public String index() {
		log.info("인뒉스");
		return "String Security Filter....";
	}
	
	@GetMapping("/loginPage")
	public String loginPage() {
		return "Spring Customizing Form...";
	}
	
	@GetMapping("/home")
	public String home() {
		log.info("서러서러성고로고로고로공");
		return "home...";
	}
}
