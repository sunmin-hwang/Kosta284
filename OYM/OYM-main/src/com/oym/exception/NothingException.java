package com.oym.exception;

public class NothingException extends Exception {
	public NothingException() {
		this("아무것도 없습니다.");
	}
	/**
	 * 
	 * @param message 메세지
	 */
	public NothingException(String message) {
		super(message);
	}
}