package com.edu.bank;

//Single Line Comment

/*
 * Multi Line Comment
 * */

/**
 * <pre>
 * {@code
 *  은행 계좌 정보를 저장하는 클래스
 *  
 *  이번  Java Document 주석 사용법을 예시로 작성
 *  이런 작업은 공동작업을 하기 위한 효율적 작업으로 사용되거나
 *  혹운
 *  개발자가 자신의 코드를 보완설명하기 위해서 반드시 사용하는 작업 방식입니다.
 * }
 * 
 * </pre>
 * 
 * 
 * @author SUN
 * @version Test Project version 1.0.1
 * @since JDK 17
 */
public class Account {
	
	//field
	/**
	 * 계좌번호
	 * 8자리 숫자로 지정
	 */
	public int accNumber;
	/**
	 * 은행명
	 */
	public String bankName;
	/**
	 * 계좌에 남아있는 잔액
	 * 혹은
	 * 개설시 필요한 조건으로서의 잔액 
	 */
	public double balance;
	
	
	/**
	 * Account 기본 생성자
	 */
	public Account() { }

	/**
	 * 
	 * Account 명시적 생성자
	 * @param accNumber 계좌번호
	 * @param bankName 은행명
	 */
	public Account(int accNumber, String bankName) {
		this.accNumber = accNumber;
		this.bankName = bankName;
	}
	
	//setter
	/**
	 * 
	 * 잔액 설정
	 * @param balance 잔액
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	//getter
	/**
	 * 
	 * @return 통장 정보 반환
	 */
	public String getAccountInfo() {
		return "계좌번호 : " + accNumber + ", 은행명 : " + bankName + ", 잔액 : " + balance + "원";
	}
	
	/**
	 * 
	 * @return 잔액 반환
	 * 
	 */
	//@deprecated deposit 메소드로 대체 {@link #deposit(double)}
	public double getbalance() {
		return balance;
	}
	
	//기능
	/**
	 * 특정한 금액을 계좌에서 출금하는 기능
	 * @param amt 출금액
	 */
	public void withdraw(double amt) {
		balance -= amt;
	}
	
	/**
	 * 특정한 금액을 계좌에 입금하는 기능
	 * @param amt 입금액
	 */
	public void deposit(double amt) {
		balance += amt;
	}
	
}
