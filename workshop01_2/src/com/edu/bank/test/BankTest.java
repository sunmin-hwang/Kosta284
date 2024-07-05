package com.edu.bank.test;

import java.util.Scanner;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//고객 생성
		Customer james = new Customer("James", "서울");
		Customer tomas = new Customer("Tomas", "종로");
		
		//고객정보 출력
		System.out.println("고객님의 정보입니다.");
		System.out.println(james.getCustomerInfo());
		System.out.println(tomas.getCustomerInfo());
		System.out.println("------------------------");
		
		//James 계좌 생성
		System.out.println("James님의 계좌 생성중...");
		System.out.print("계좌번호를 입력하세요 : ");
		int jamesAccNumber = Integer.parseInt( sc.nextLine());
		System.out.print("은행명을 입력하세요 : ");
		String jamesBankName = sc.nextLine();
		System.out.print("잔액을 입력하세요 : ");
		double jamesBalance = Double.parseDouble( sc.nextLine());
		james.openAccount(new Account(jamesAccNumber, jamesBankName, jamesBalance));
		System.out.println("James님의 계좌 생성완료!!");
		System.out.println("---------------------");
		
		//Tomas 계좌 생성
		System.out.println("Tomas님의 계좌 생성중...");
		System.out.print("계좌번호를 입력하세요 : ");
		int tomasAccNumber = Integer.parseInt( sc.nextLine());
		System.out.print("은행명을 입력하세요 : ");
		String tomasBankName = sc.nextLine();
		System.out.print("잔액을 입력하세요 : ");
		double tomasBalance = Double.parseDouble( sc.nextLine());
		tomas.openAccount(new Account(tomasAccNumber, tomasBankName, tomasBalance));
		System.out.println("Tomas님의 계좌 생성완료!!");
		System.out.println("---------------------");
		
		//계좌 정보 가져옴
		Account jamesAccount = james.getAccount();
		Account tomasAccount = tomas.getAccount();
		
		//계좌 정보 출력
		System.out.println("James님의 계좌입니다 : " + jamesAccount.getAccountInfo());
		System.out.println("Tomas님의 계좌입니다 : " + tomasAccount.getAccountInfo());
		System.out.println("---------------------------------------");
		
		//입출금 후 잔액 출력
		jamesAccount.deposit(100);
		System.out.println("10000원 입금 후 잔액 : " + jamesAccount.getbalance() + "원");
		jamesAccount.deposit(30000);
		System.out.println("30000원 입금 후 잔액 : " + jamesAccount.getbalance() + "원");
		jamesAccount.withdraw(20000);
		System.out.println("20000원 출금 후 최종 잔액 : " + jamesAccount.getbalance() + "원");
		jamesAccount.withdraw(80000);
		System.out.println("20000원 출금 후 최종 잔액 : " + jamesAccount.getbalance() + "원");
		sc.close();
	}
}
