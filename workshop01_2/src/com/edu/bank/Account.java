package com.edu.bank;

public class Account {
	
	public int accNumber;
	public String bankName;
	public double balance;
	
	
	
	public Account() { }
	
	public Account(int accNumber, String bankName, double balance) {
		if(!bankName.equals("KB") || (bankName.equals("KB") && balance >= 10000)) {
			this.accNumber = accNumber;
			this.bankName = bankName;
			this.balance = balance;
		}else {
			System.out.println("KB은행의 경우 잔액이 10000원 이상일 때에만 계좌 개설이 가능합니다.");
			System.exit(0);
		}
	}

	
	public String getAccountInfo() {
		return "계좌번호 : " + accNumber + ", 은행명 : " + bankName + ", 잔액 : " + balance + "원";
	}
	
	public double getbalance() {
		return balance;
	}
	
	public void withdraw(double amt) {
		if(amt<=balance) {
		    balance -= amt;
		}else {
			System.out.println("잔액부족");
			return;
		}
	}
	
	public void deposit(double amt) {
		if(amt>=1000) {
			balance += amt;
		}else {
			System.out.println("입금액은 1000원 이상이어야합니다");
			return;
		}
		
	}
	
}
