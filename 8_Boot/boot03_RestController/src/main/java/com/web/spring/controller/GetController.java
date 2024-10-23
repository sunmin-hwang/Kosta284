package com.web.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Member;
import org.springframework.web.bind.annotation.RequestParam;


/*
 * 단순한 페이지를 요청하는 Get방식의 Controller..
 * */
@RestController
public class GetController {
	//1.
	@GetMapping("/members")
	public String getMember(Member member) {
		//서비스 함수 호출결과로 id에 해당하는 Member객체를 리턴받았다 치고
		Member rvo = new Member("KOSTA", "1234", "홍종각", "종각");
		return rvo.toString();
	}
	
	//2. http://localhost:9000/member?name=홍종각&address=종각
	@GetMapping("/member")
	public String getMember(@RequestParam String name, @RequestParam String address) {
		return name + "님이 사는 곳은 " + address + "입니다.";
	}
	
	//3. http://localhost:9000/member/James
	/*@GetMapping("/member/{name}")
	public String getMember(@PathVariable String name) {
		return "Hello, " + name;
	}*/

	@GetMapping("/member/{name}")
	public String getMember(@PathVariable("name") String myName) {
		return "Hello, " + myName;
	}
	
}
