package com.edu.exception;

public class DMLException extends Exception {
	public DMLException(String message) {
		super(message);
	}
	
	public DMLException() {
		this("회원 추가, 삭제, 생성시 작업이 제대로 이루어지지 않았습니다.");
		
	}
}
