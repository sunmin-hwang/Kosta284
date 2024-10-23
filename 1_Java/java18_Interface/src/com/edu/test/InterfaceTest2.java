package com.edu.test;

interface Movable{
	void move(int x, int y);
	void jump(int height);
}

interface Attackable{
	void attack(Unit u);
}

interface Fightable extends Movable, Attackable{
	
}

class Fighter extends Unit implements Fightable{

	@Override
	public void move(int x, int y) {
		
	}

	@Override
	public void jump(int height) {
		
	}

	@Override
	public void attack(Unit u) {
		
	}
	
}

class Unit{
	int currentHP;// 유닛의 체력
	int x;// 유닛의 x 좌표
	int y;// 유닛의 y 좌표
}

public class InterfaceTest2 {

	public static void main(String[] args) {
		Fighter f = new Fighter();
		if(f instanceof Unit) System.out.println("f는 Unit의 자손입니다.");
		if(f instanceof Fightable) System.out.println("f는 Fightable의 자손입니다.");
		if(f instanceof Movable) System.out.println("f는 Movable의 자손입니다.");
		if(f instanceof Attackable) System.out.println("f는 Attackable의 자손입니다.");
		if(f instanceof Object) System.out.println("f는 Object의 자손입니다.");
	}

}
