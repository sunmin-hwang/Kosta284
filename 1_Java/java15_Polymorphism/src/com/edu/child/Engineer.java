package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Engineer extends Employee{
	
	// 기본적으로 Employee의 멤버를 물려받는다.
	// 자식의 멤버만 추가
	private String tect;
	private int bonus;
	
	//명시적 생성자 추가
	public Engineer(String name, double salary, MyDate birthDate, String tect, int bonus) {
		super(name, salary, birthDate);
		this.tect = tect;
		this.bonus = bonus;
	}
	
	public String getTect() {
		return tect;
	}

	public void changeTect(String tect) {
		this.tect = tect;
	}

	public int getBonus() {
		return bonus;
	}

	public void changeBonus(int bonus) {
		this.bonus = bonus;
	}

	//부모가 물려준 기능을 받아서...1step...선언부는 그대로
	//그걸 자신에게 맞게 고쳐쓴다...2step...구현부는 다르게
	//Method Overriding(메소드 재정의)
	@Override
	public String getDetails() {
		return super.getDetails() + ", tech : " + tect;
	}
	
	public String toString() {
		return super.getDetails() + ", tech : " + tect;
	}
}
