package com.edu.condition.test2;

import java.util.Random;

public class NoBreakSwitchTest2 {

	public static void main(String[] args) {
		//8~11 사이의 임의의 값이 할당되도록 로직을 작성
		int time = (int)(Math.random() * 4) + 8;
		System.out.println(time);
		
		Random random = new Random();
		int time1 = random.nextInt(4) + 8;
		System.out.println(time1);
		
		switch (time) {
		case 8:
			System.out.println("출근준비를 합니다.");
		case 9:
			System.out.println("회사 도착 Safe~~~.");
		case 10:
			System.out.println("오전 업무를 봅니다.");
		case 11:
			System.out.println("외근 나갑니다.");
		}
	}

}
