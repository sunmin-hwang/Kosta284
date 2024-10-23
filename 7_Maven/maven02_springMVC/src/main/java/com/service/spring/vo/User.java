package com.service.spring.vo;

public class User {
	private String userName;
	private String userAddr;
	private String id;
	private String password;
	
	public User() { }
	
	public User(String userName, String userAddr, String id, String password) {
		super();
		this.userName = userName;
		this.userAddr = userAddr;
		this.id = id;
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userAddr=" + userAddr + "]";
	}
	
}
