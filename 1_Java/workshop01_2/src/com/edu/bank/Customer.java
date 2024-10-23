package com.edu.bank;

public class Customer {
	//field
	String name;
	String address;
	
	Account account;

	//생성자
	public Customer() { }
	
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}


	//setter
	public void openAccount(Account account) {
		this.account = account;
	}
	
	//getter
	public Account getAccount() {
		return account;
	}

	public String getCustomerInfo() {
		return "고객명 : " + name + ", 주소 : " + address;
	}	
	
}
