package com.web.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Member;


@RestController
@RequestMapping("api/v1")
public class PutController {

	/*
	  ResponseEntity를 사용하면 좋은 이점
	  1. 결과데이터와 함께 상태 코드값을 지정할 수 있다.
	  2. 에러코드와 성공여부 상태 코드값을 섬세하게 지정해서 클라이언트에게 전달 할 수 있다.
	 */
	
	@PutMapping("/members")
	public ResponseEntity<?> updateMember(@RequestBody Member pvo) {
		//201 Create
		//200 Success
		//202 Update
		return ResponseEntity.status(202).body(pvo);
	}
	
	
}
