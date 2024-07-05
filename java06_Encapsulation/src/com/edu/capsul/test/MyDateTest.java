package com.edu.capsul.test;

import java.util.Scanner;

import com.edu.capsul.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate md = new MyDate();
		
		//md.month = 13;
		//md.day = 33;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("월 입력 >>>");
		int month = sc.nextInt();
		
		md.setMonth(month);
		
		System.out.println("날짜 입력 >>>");
		int day = sc.nextInt();
		
		md.setDay(day);
		
		System.out.println("Today is " + md.getMonth() + "월 " + md.getDay() + "일 입니다."); 
		
		sc.close();
	}

}
