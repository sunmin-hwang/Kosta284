package com.edu.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException(String message) {
		super(message);
	}
	
	public RecordNotFoundException() {
		this("RecordNotFound...존재하지 않는 사람입니다.");
		
	}
}
