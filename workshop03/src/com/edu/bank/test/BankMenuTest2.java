package com.edu.bank.test;

import java.util.Scanner;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankMenuTest2 {

	public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		Customer james = new Customer("James", "서울");
		james.openAccount(new Account(123, "KB", 20000));
		do {
			System.out.println("1. 고객 생성 2. 계좌 개설 3. 입금 4. 출금 5. 잔액조회 6. 고객정보조회 7. 종료");
			int menu = sc.nextInt();
			switch (menu) {
			    case 1:
			    	System.out.print("이름 : ");
			    	String name = sc.next();
			    	System.out.print("주소 : ");
			    	String address = sc.next();
			    	@SuppressWarnings("unused") Customer newCustomer = new Customer(name, address);
			    	break;
			    case 2:
			    	System.out.print("계좌번호를 입력하세요 : ");
					int jamesAccNumber = Integer.parseInt( sc.nextLine());
					System.out.print("은행명을 입력하세요 : ");
					String jamesBankName = sc.nextLine();
					System.out.print("잔액을 입력하세요 : ");
					double jamesBalance = Double.parseDouble( sc.nextLine());
					james.openAccount(new Account(jamesAccNumber, jamesBankName, jamesBalance));
					if(james.getAccount().getBankName()==null) {
						System.out.println("KB국민은행 통장 개설에 실패했습니다.");
						break;
					}
					break;
			    case 3:
			    	System.out.print("입금액을 입력하세요 : ");
			    	int depositamt = sc.nextInt();
			    	james.getAccount().deposit(depositamt);
			    	break;
			    case 4:
			    	System.out.print("출금액을 입력하세요 : ");
			    	int withdrawamt = sc.nextInt();
			    	james.getAccount().withdraw(withdrawamt);
			    	break;
			    case 5:
			    	System.out.println(james.getAccount().getBalance());
			    	break;
			    case 6:
			    	System.out.println(james.getCustomerInfo());
			    	break;
			    case 7: 
				    System.out.println("프로그램 종료");
				    System.exit(0);
			}
		}while(true);
		
	}

}
